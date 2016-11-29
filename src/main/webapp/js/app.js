function home() {
	window.location.href = "home";
}

function administration() {
	window.location.href = "administration";
}

function logout() {
	window.location.href = "logout";
}

var isShown = false;
function setPassword() {
	if (isShown) {
		$('#formPassword').hide();
		isShown = false;
	} else {
		promptForPassword();
		$('#formPassword').show();
		isShown = true;
	}
}

function promptForPassword(){
	
}

function validatePassword() {
	var newPassword = $('input[name=newPassword]').val();
	var confirmNewPassword = $('input[name=confirmNewPassword]').val();
	if (newPassword != confirmNewPassword) {
		toastr.error("The passwords must match!");
	} else {
		console.log("POST")
		toastr.options.onHidden = function() {
			$('#formPassword').submit();
		}
		toastr.options.timeOut = 1000;
		toastr.success("New password has been updated!");
	}
}

$('.updateUser')
		.click(
				function() {
					var row = $(this).closest('tr');
					var id_user = row.find('td.id_user').text();
					var roleName = row.find('select.roleName')
							.find(":selected").text();
					var username = row.find('td.username').text();
					var password = row.find('td.password').text();
					var surname = row.find('td.surname').text();
					var name = row.find('td.name').text();
					var avatar = row.find('td.avatar').text();
					var country = row.find('td.country').text();
					var date = row.find('td.date').text();
					console.log(id_user + "," + roleName + "," + username + ","
							+ password + "," + surname + "," + name + ","
							+ avatar + "," + country + "," + date);
				});

$('.deleteUser')
		.click(
				function() {
					var row = $(this).closest('tr');
					bootbox
							.confirm({
								message : "<h3 class='text-danger'>Are you sure you want to delete this user?</h3>",
								buttons : {
									confirm : {
										label : 'Yes',
										className : 'btn-success'
									},
									cancel : {
										label : 'No',
										className : 'btn-danger'
									}
								},
								callback : function(result) {
									console
											.log('This was logged in the callback: '
													+ result);
									if (result) {
										var id_user = row.find('td.id_user')
												.text();
										var roleName = row.find(
												'select.roleName').find(
												":selected").text();
										var username = row.find('td.username')
												.text();
										var password = row.find('td.password')
												.text();
										var surname = row.find('td.surname')
												.text();
										var name = row.find('td.name').text();
										var avatar = row.find('td.avatar')
												.text();
										var country = row.find('td.country')
												.text();
										var date = row.find('td.date').text();
										row.remove();

										console.log(id_user + "," + roleName
												+ "," + username + ","
												+ password + "," + surname
												+ "," + name + "," + avatar
												+ "," + country + "," + date);
									}
								}
							});
				});

$('.updateRole').click(function() {
	var row = $(this).closest('tr');
	var id_role = row.find('td.id_role').text();
	var name = row.find('td.name').text();
	var maxInactiveInterval = row.find('td.maxInactiveInterval').text();
	console.log(id_role + "," + name + "," + maxInactiveInterval);
});

$('.deleteRole')
		.click(
				function() {
					var row = $(this).closest('tr');
					bootbox
							.confirm({
								message : "<h3 class='text-danger'>Are you sure you want to delete this role?</h3>",
								buttons : {
									confirm : {
										label : 'Yes',
										className : 'btn-success'
									},
									cancel : {
										label : 'No',
										className : 'btn-danger'
									}
								},
								callback : function(result) {
									console
											.log('This was logged in the callback: '
													+ result);
									if (result) {
										var id_role = row.find('td.id_role')
												.text();
										var name = row.find('td.name').text();
										var maxInactiveInterval = row.find(
												'td.maxInactiveInterval')
												.text();
										row.remove();
										console.log(id_role + "," + name + ","
												+ maxInactiveInterval);
									}
								}
							});
				});