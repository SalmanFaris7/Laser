extends Area2D

var max_bounces = 5

onready var ray = $Sprite/Camera2D/RayCast2D
onready var line = $Line2D
onready var Mirror1= get_tree().get_root().get_node("/root/Node2D/Area2D/Mirror")
onready var Mirror2= get_tree().get_root().get_node("/root/Node2D/Area2D/Mirror2")
onready var Mirror3= get_tree().get_root().get_node("/root/Node2D/Area2D/Mirror3")


# Called when the node enters the scene tree for the first time.
func _process(delta):
	line.clear_points()
	
	if Input.is_mouse_button_pressed(BUTTON_LEFT):
		
			line.add_point(Vector2.ZERO)
			#Mirror1.rotate(.1)
			#Mirror2.rotate(.1)
			#Mirror3.rotate(.1)
			
			ray.global_position = line.global_position
			ray.cast_to = (get_global_mouse_position()-line.global_position).normalized()*100000
			#ray.cast_to = (Vector2(1,0).direction_to(Vector2(0,0))).normalized()*100000
			ray.force_raycast_update()
			
			var prev = null
			var bounces = 0
			
			while true:
				if not ray.is_colliding():
					var pt = ray.global_position + ray.cast_to
					line.add_point(line.to_local(pt))
					break
					
				var coll = ray.get_collider()
				var pt = ray.get_collision_point()	
				
				line.add_point(line.to_local(pt))
				
				if not coll.is_in_group("Mirrors"):
					break
					
				var normal = ray.get_collision_normal()	
				
				
				if normal == Vector2.ZERO:
					break
					
				if prev != null:
					prev.collision_mask = 3
					prev.collision_layer = 3
					
				prev = coll	
				prev.collision_mask = 0
				prev.collision_layer = 0
				
				
				
				ray.global_position = pt
				ray.cast_to = ray.cast_to.bounce(normal)
				ray.force_raycast_update()
				
				bounces += 1
				if bounces >= max_bounces:
					break
				
			if prev != null:
				prev.collision_mask = 3
				prev.collision_layer = 3
				
			
			
			
func _physics_process(delta):
		var vel = Vector2(
			int(Input.is_action_pressed("right"))-int(Input.is_action_pressed("left")),
			int(Input.is_action_pressed("down"))-int(Input.is_action_pressed("up"))
		)		
