extends Control

onready var username_input = get_node("NinePatchRect/VBoxContainer/UserName")
onready var userpassword = get_node("NinePatchRect/VBoxContainer/Password")
onready var login_button = get_node("NinePatchRect/VBoxContainer/LoginButton")


# Called when the node enters the scene tree for the first time.
func _on_LoginButton_pressed():
	if username_input.text == "" or userpassword.text == "":
		
		print("Please provide valid userID and password")
	else:
		login_button.disabled = true
		var username = username_input.get_text()
		var password = userpassword.get_text()
		print("attempting to login")
		Gateway.ConnectToServer(username, password)	
