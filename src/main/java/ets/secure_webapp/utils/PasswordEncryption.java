package ets.secure_webapp.utils;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryption {
	// Algorithme de hash utilisé
	public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA512";

	// Taille du sel
	public static final int SALT_BYTE_SIZE = 64; // 512/8
	// Taille du hash généré
	public static final int HASH_BYTE_SIZE = 64; // 512/8

	// Nombre d'itération effectuées par l'algorithme
	// Le but est de ralentir le traitement pour rendre compliqué le piratage de
	// nos mots de passe par "brute force"
	public static final int PBKDF2_ITERATIONS = 20000;

	// Génération du mot de passe hashé
	public static String generatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Création du sel
		SecureRandom random = new SecureRandom();
		byte[] sel = new byte[SALT_BYTE_SIZE];
		random.nextBytes(sel);

		// Hash du mot de passe
		byte[] hash = generateHash(password, sel);

		// format salt:hash
		return toHex(sel) + ":" + toHex(hash);
	}

	// Validation du mot de passe
	// On ne déchiffre pas le hash, on va recalculer le hash avec le mot de
	// passe saisi et vérifier qu'on obtient le même résultat
	public static boolean validatePassword(String password, String hashCorrect)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Séparation du hash et du sel
		String[] params = hashCorrect.split(":");
		byte[] sel = fromHex(params[0]);
		byte[] hash = fromHex(params[1]);

		// Génération du hash du mot de passe testé avec le même sel
		byte[] hashAValider = generateHash(password, sel);
		// Comparaison des deux hash
		return Arrays.equals(hash, hashAValider);
	}

	// Méthode calculant le hash
	// C'est là qu'est toute la sécurisation, on utilise des classes
	// javax.crypto.
	private static byte[] generateHash(String password, byte[] sel)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), sel, PBKDF2_ITERATIONS, HASH_BYTE_SIZE * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
		return skf.generateSecret(spec).getEncoded();
	}

	// Méthode de transformation byte[] -> String
	private static byte[] fromHex(String hex) {
		byte[] binary = new byte[hex.length() / 2];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return binary;
	}

	// Méthode de transformation String -> byte[]
	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

	// Génération des mots de passe de nos utilisateurs
	public static void main(String[] args) {
		try {
			System.out.println(String.format("usercercle@test.com=%s", PasswordEncryption.generatePassword("user")));
			System.out.println(String.format("usercarre@test.com=%s", PasswordEncryption.generatePassword("user")));
			System.out.println(String.format("admin@test.com=%s", PasswordEncryption.generatePassword("admin")));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
}
