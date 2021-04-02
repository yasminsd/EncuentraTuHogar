# SD_Hotel
Aplicación Web de reservas de habitaciones, servicios y gestión de cobros en SD_Hotel.
Parte pública:
- Habitaciones disponibles y precios SD_Hotel.
- Servicios disponibles y precios SD_Hotel.
Parte provada:
- Registro de usuarios y viajeros.
- Reserva de habitaciones.
- Reserva de servicios.
- Cobro reservas y servicios utilizados por el viajero.
Descripción lógica de las entidades:
- Viajero
   - Almacena los datos del viajero.
- Usuario
   - Esta entidad posee los datos relevantes que debe poseer un usuario registrado en el sistema. 
- Reserva
   - Almacena los datos que tienen relación con las reservas para la gestión de disponibilidad de habitaciones.
- Habitación
   - Esta entidad es la más importante, ya que todas las demás entidades giran y tienen relación con respecto a ella.
- Servicios
   - Almacena los datos que tiene relación con los servicios que ofrece el hotel y su valor correspondiente.
- Pago:
   - Esta entidad almacena el abono realizado por el viajero.
