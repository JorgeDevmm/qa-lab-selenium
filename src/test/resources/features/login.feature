#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Juntoz
    Cuando inicio sesión con las credenciales correo: "jorge29luis10@gmail.com" y contraseña: "online"
    Entonces valido que debería aparecer el título de "Abre tu tienda"
    Y hago clic en Envío Gratis
    Y selecciono el primer producto y hago clic en agregar al carrito
    Entonces Valido que se haya agregado exitosamente al Carrito "Tu producto fue añadido"
#    Y hago clic en Ir al carrito