/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 23-feb.-2021 19:36:03 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS Area CASCADE
;

DROP TABLE IF EXISTS Cliente CASCADE
;

DROP TABLE IF EXISTS Contrato CASCADE
;

DROP TABLE IF EXISTS Espacio CASCADE
;

DROP TABLE IF EXISTS Parqueadero CASCADE
;

DROP TABLE IF EXISTS Servicio CASCADE
;

DROP TABLE IF EXISTS Tarifa CASCADE
;

DROP TABLE IF EXISTS Vehiculo CASCADE
;

/* Create Tables */

CREATE TABLE Area
(
	k_idArea integer NOT NULL,    -- Identificador que permite identificar el area de cada tipo de veh�culo dentro del parqueadero
	n_tipoVehiculoArea varchar(20) NOT NULL,    -- Corresponde al tipo de veh�culo que pueden ser parqueados en el �rea
	q_cupos integer NULL,    -- Cantidad de cupos que tiene el �rea para poder ser utilizados por un veh�culo
	q_cuposDisponibles integer NULL,    -- Cantidad de cupos que no est�n siendo utilizados
	k_codigoParqueadero integer NOT NULL
)
;

CREATE TABLE Cliente
(
	k_identificacionCliente integer NOT NULL,    -- La c�dula de ciudadan�a es el documento de identificaci�n de los ciudadanos colombianos mayores de 18 a�os y es el atributo que permitira identificar a cada cliente
	n_tipoIdentificacion varchar(20) NOT NULL,    -- Tipo de documento del cliente
	n_primerNombre varchar(20) NOT NULL,    -- Primer nombre del cliente
	n_segundoNombre varchar(20) NULL,    -- Segundo nombre del cliente
	n_primerApellido varchar(20) NOT NULL,    -- Primer apellido del cliente
	n_segundoApellido varchar(20) NOT NULL,    -- Segundo apellido del cliente
	i_sexo varchar(1) NOT NULL,    -- Sexo del cliente
	n_direccion varchar(50) NOT NULL,    -- Direccion de residencia del cliente
	o_telefonoCliente numeric(10) NOT NULL    -- N�mero de telefono para contactarse con el cliente
)
;

CREATE TABLE Contrato
(
	k_idContrato integer NOT NULL,    -- C�digo que permite identificar cada uno de los contratos
	i_periodo varchar(7) NOT NULL,    -- El parqueadero brinda servicios de d�a, semana, mes y a�o y solo se puede escoger uno de estos
	f_inicio date NOT NULL,    -- Fecha en la que da inicio el contrato
	f_fin date NOT NULL,    -- Fecha en la que finaliza el contrato
	v_valorPago integer NOT NULL,    -- Monto total que el cliente debe pagar al hacer el contrato
	i_estado boolean NOT NULL,
	k_codigoParqueadero integer NOT NULL,
	k_identificacionCliente integer NOT NULL,
	k_placa varchar(9) NOT NULL
)
;

CREATE TABLE Espacio
(
	k_idEspacio integer NOT NULL,
	i_estado boolean NOT NULL,    -- Estado de cada uno de los lugares de cada parquedero, puede estar marcado unicamente con dos estados: Disponible u Ocupado
	k_codigoParqueadero integer NOT NULL,
	k_idArea integer NOT NULL
)
;

CREATE TABLE Parqueadero
(
	k_codigoParqueadero integer NOT NULL,    -- C�digo �nico asignado a cada parquedero. Permitir� reconocer cada parqueadero de entre los dem�s
	n_nombreParqueadero varchar(30) NOT NULL,    -- Nombre de cada uno de los parqueaderos
	n_direccion varchar(50) NOT NULL,    -- Direcci�n en la cual se ubica el parqueadero
	n_localidad varchar(20) NOT NULL,    -- Localidad de la ciudad de Bogot� en la cual se encuentra el parqueadero
	i_subterraneo boolean NOT NULL,    -- Subterraneo es un atributo que al ser marcado como 'True' indica que el parqueadero es subterraneo y al marcarse como 'False' el parqueadero se entiende que es por nivel de altura
	q_cantidadNiveles integer NOT NULL,    -- Cantidad o n�mero de niveles que tiene el parqueadero, ya sean subterraneos o de altura
	i_tipoSuelo varchar(34) NOT NULL,    -- El tipo de suelo es la caracteristica f�sica que tiene el parqueadero y puede tomar valores como: concreto asfalto  gravilla lavada de r�o compactada
	i_factorDemandaZonal numeric(2,1) NOT NULL,    -- El factor de demanda que depende de la zona en que est� ubicado el aparcadero y/o estacionamiento y toma valores de 0.8 o 1.0 a partir de la demanda del sector, el estrato social y la actividad del sector
	o_contrasenaParqueadero varchar(30) NOT NULL,    -- Se asignara una contrase�a unica a cada Parqueadero para el ingreso al sistema 'AparcApp'
	i_estadoParqueadero varchar(50) NOT NULL    -- El estado del parqueadero me permite saber si el parqueadero est� activo o no
)
;

CREATE TABLE Servicio
(
	k_idServicio integer NOT NULL,    -- Atributo que permite identificar cada servicio realizado
	f_ingreso date NOT NULL,    -- Fecha en la que ingresa el veh�culo al Parqueadero
	o_horaIngreso time without time zone NOT NULL,    -- Hora en la que ingresa el veh�culo al Parqueadero
	f_salida date NULL,    -- Fecha en la que se retira el veh�culo del Parqueadero
	o_horaSalida time without time zone NULL,    -- Hora en la que sale el veh�culo del Parqueadero
	v_pagoTotal integer NULL,    -- Valor total a pagar 
	k_placa varchar(9) NOT NULL,
	k_idEspacio integer NOT NULL,
	k_codigoParqueadero integer NOT NULL,
	k_idArea integer NOT NULL
)
;

CREATE TABLE Tarifa
(
	k_idTarifa integer NOT NULL,    -- C�digo unico para cada tarifa
	n_tipoVehiculo varchar(20) NOT NULL,    -- Nombre del tipo de vehiculo
	v_valorMaxMinuto integer NOT NULL,    -- Valor maximo por minuto 
	k_codigoParqueadero integer NOT NULL
)
;

CREATE TABLE Vehiculo
(
	k_placa varchar(9) NOT NULL,    -- Placa que permite identificar al veh�culo que utiliza el parqueadero
	n_tipoVehiculo varchar(20) NOT NULL,    -- Nombre del tipo de veh�culo
	n_marca varchar(14) NULL,    -- Nombre de la marca del veh�culo, solo requerido si ingresa por contrato
	n_color varchar(14) NULL,    -- Nombre del color del veh�culo, solo requerido si ingresa por contrato
	n_modelo varchar(20) NULL    -- Nombre del modelo del veh�culo, solo requerido si ingresa por contrato
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Area ADD CONSTRAINT PK_Area
	PRIMARY KEY (k_idArea,k_codigoParqueadero)
;

ALTER TABLE Area ADD CONSTRAINT CK_idArea CHECK (k_idArea>0)
;

ALTER TABLE Area ADD CONSTRAINT CK_cupos CHECK (q_cupos>=0)
;

ALTER TABLE Area ADD CONSTRAINT CK_cuposDisponibles CHECK (q_cuposDisponibles>=0 AND q_cuposDisponibles<=q_cupos)
;

CREATE INDEX IXFK_Area_Parqueadero ON Area (k_codigoParqueadero ASC)
;

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente
	PRIMARY KEY (k_identificacionCliente)
;

ALTER TABLE Cliente ADD CONSTRAINT CK_identificacionCliente CHECK (k_identificacionCliente>0)
;

ALTER TABLE Cliente ADD CONSTRAINT CK_sexo CHECK (i_sexo IN ('M', 'F', 'O'))
;

ALTER TABLE Contrato ADD CONSTRAINT PK_Contrato
	PRIMARY KEY (k_idContrato)
;

ALTER TABLE Contrato ADD CONSTRAINT CK_fechaFin CHECK (f_fin>f_inicio)
;

ALTER TABLE Contrato ADD CONSTRAINT CK_IdContrato CHECK (k_idContrato>0)
;

ALTER TABLE Contrato ADD CONSTRAINT CK_valorPago CHECK (v_valorPago>0)
;

CREATE INDEX IXFK_Contrato_Cliente ON Contrato (k_identificacionCliente ASC)
;

CREATE INDEX IXFK_Contrato_Parqueadero ON Contrato (k_codigoParqueadero ASC)
;

CREATE INDEX IXFK_Contrato_Vehiculo ON Contrato (k_placa ASC)
;

ALTER TABLE Espacio ADD CONSTRAINT PK_Espacio
	PRIMARY KEY (k_idEspacio,k_codigoParqueadero,k_idArea)
;

ALTER TABLE Espacio ADD CONSTRAINT CK_idEspacio CHECK (k_idEspacio>0)
;

CREATE INDEX IXFK_Espacio_Area ON Espacio (k_idArea ASC,k_codigoParqueadero ASC)
;

ALTER TABLE Parqueadero ADD CONSTRAINT PK_Parqueadero
	PRIMARY KEY (k_codigoParqueadero)
;

ALTER TABLE Parqueadero 
  ADD CONSTRAINT UK_nombreParqueadero UNIQUE (n_nombreParqueadero)
;

ALTER TABLE Parqueadero ADD CONSTRAINT CK_codigoParqueadero CHECK (k_codigoParqueadero>0)
;

ALTER TABLE Parqueadero ADD CONSTRAINT CK_factorDemandaZonal CHECK (i_factorDemandaZonal IN (0.8,1.0))
;

ALTER TABLE Parqueadero ADD CONSTRAINT CK_cantidadNiveles CHECK (q_cantidadNiveles>0)
;

ALTER TABLE Servicio ADD CONSTRAINT PK_Servicio
	PRIMARY KEY (k_idServicio)
;

ALTER TABLE Servicio ADD CONSTRAINT CK_idServicio CHECK (k_idServicio>0)
;

ALTER TABLE Servicio ADD CONSTRAINT CK_pagoTotal CHECK (v_pagoTotal>0)
;

CREATE INDEX IXFK_Servicio_Espacio ON Servicio (k_idEspacio ASC,k_codigoParqueadero ASC,k_idArea ASC)
;

CREATE INDEX IXFK_Servicio_Vehiculo ON Servicio (k_placa ASC)
;

ALTER TABLE Tarifa ADD CONSTRAINT PK_Tarifa
	PRIMARY KEY (k_idTarifa)
;

ALTER TABLE Tarifa ADD CONSTRAINT CK_idTarifa CHECK (k_idTarifa>0)
;

ALTER TABLE Tarifa ADD CONSTRAINT CK_valorMaxMinuto CHECK (v_valorMaxMinuto>=10)
;

CREATE INDEX IXFK_Tarifa_Parqueadero ON Tarifa (k_codigoParqueadero ASC)
;

ALTER TABLE Vehiculo ADD CONSTRAINT PK_Vehiculo
	PRIMARY KEY (k_placa)
;

/* Create Foreign Key Constraints */

ALTER TABLE Area ADD CONSTRAINT FK_Area_Parqueadero
	FOREIGN KEY (k_codigoParqueadero) REFERENCES Parqueadero (k_codigoParqueadero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Contrato ADD CONSTRAINT FK_Contrato_Cliente
	FOREIGN KEY (k_identificacionCliente) REFERENCES Cliente (k_identificacionCliente) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Contrato ADD CONSTRAINT FK_Contrato_Parqueadero
	FOREIGN KEY (k_codigoParqueadero) REFERENCES Parqueadero (k_codigoParqueadero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Contrato ADD CONSTRAINT FK_Contrato_Vehiculo
	FOREIGN KEY (k_placa) REFERENCES Vehiculo (k_placa) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Espacio ADD CONSTRAINT FK_Espacio_Area
	FOREIGN KEY (k_idArea,k_codigoParqueadero) REFERENCES Area (k_idArea,k_codigoParqueadero) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Servicio ADD CONSTRAINT FK_Servicio_Espacio
	FOREIGN KEY (k_idEspacio,k_codigoParqueadero,k_idArea) REFERENCES Espacio (k_idEspacio,k_codigoParqueadero,k_idArea) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Servicio ADD CONSTRAINT FK_Servicio_Vehiculo
	FOREIGN KEY (k_placa) REFERENCES Vehiculo (k_placa) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Tarifa ADD CONSTRAINT FK_Tarifa_Parqueadero
	FOREIGN KEY (k_codigoParqueadero) REFERENCES Parqueadero (k_codigoParqueadero) ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

COMMENT ON TABLE Area
	IS 'El �rea es la adecuaci�n que tiene el parqueadero para cada tipo de veh�culo '
;

COMMENT ON COLUMN Area.k_idArea
	IS 'Identificador que permite identificar el area de cada tipo de veh�culo dentro del parqueadero'
;

COMMENT ON COLUMN Area.n_tipoVehiculoArea
	IS 'Corresponde al tipo de veh�culo que pueden ser parqueados en el �rea'
;

COMMENT ON COLUMN Area.q_cupos
	IS 'Cantidad de cupos que tiene el �rea para poder ser utilizados por un veh�culo'
;

COMMENT ON COLUMN Area.q_cuposDisponibles
	IS 'Cantidad de cupos que no est�n siendo utilizados'
;

COMMENT ON TABLE Cliente
	IS 'Cliente registra los datos de las personas que hicieron el contrato con el parqueadero'
;

COMMENT ON COLUMN Cliente.k_identificacionCliente
	IS 'La c�dula de ciudadan�a es el documento de identificaci�n de los ciudadanos colombianos mayores de 18 a�os y es el atributo que permitira identificar a cada cliente'
;

COMMENT ON COLUMN Cliente.n_tipoIdentificacion
	IS 'Tipo de documento del cliente'
;

COMMENT ON COLUMN Cliente.n_primerNombre
	IS 'Primer nombre del cliente'
;

COMMENT ON COLUMN Cliente.n_segundoNombre
	IS 'Segundo nombre del cliente'
;

COMMENT ON COLUMN Cliente.n_primerApellido
	IS 'Primer apellido del cliente'
;

COMMENT ON COLUMN Cliente.n_segundoApellido
	IS 'Segundo apellido del cliente'
;

COMMENT ON COLUMN Cliente.i_sexo
	IS 'Sexo del cliente'
;

COMMENT ON COLUMN Cliente.n_direccion
	IS 'Direccion de residencia del cliente'
;

COMMENT ON COLUMN Cliente.o_telefonoCliente
	IS 'N�mero de telefono para contactarse con el cliente'
;

COMMENT ON TABLE Contrato
	IS 'El contrato es un convenio que se genera cuando se requiere de servicios superiores a 24 horas'
;

COMMENT ON COLUMN Contrato.k_idContrato
	IS 'C�digo que permite identificar cada uno de los contratos'
;

COMMENT ON COLUMN Contrato.i_periodo
	IS 'El parqueadero brinda servicios de d�a, semana, mes y a�o y solo se puede escoger uno de estos'
;

COMMENT ON COLUMN Contrato.f_inicio
	IS 'Fecha en la que da inicio el contrato'
;

COMMENT ON COLUMN Contrato.f_fin
	IS 'Fecha en la que finaliza el contrato'
;

COMMENT ON COLUMN Contrato.v_valorPago
	IS 'Monto total que el cliente debe pagar al hacer el contrato'
;

COMMENT ON TABLE Espacio
	IS 'Espacio es la entidad que corresponde a la identificaci�n del lugar que puede ser asignado  a un veh�culo en el parqueadero'
;

COMMENT ON COLUMN Espacio.i_estado
	IS 'Estado de cada uno de los lugares de cada parquedero, puede estar marcado unicamente con dos estados: Disponible u Ocupado'
;

COMMENT ON TABLE Parqueadero
	IS 'Lugar o recinto reservado para estacionar veh�culos'
;

COMMENT ON COLUMN Parqueadero.k_codigoParqueadero
	IS 'C�digo �nico asignado a cada parquedero. Permitir� reconocer cada parqueadero de entre los dem�s'
;

COMMENT ON COLUMN Parqueadero.n_nombreParqueadero
	IS 'Nombre de cada uno de los parqueaderos'
;

COMMENT ON COLUMN Parqueadero.n_direccion
	IS 'Direcci�n en la cual se ubica el parqueadero'
;

COMMENT ON COLUMN Parqueadero.n_localidad
	IS 'Localidad de la ciudad de Bogot� en la cual se encuentra el parqueadero'
;

COMMENT ON COLUMN Parqueadero.i_subterraneo
	IS 'Subterraneo es un atributo que al ser marcado como ''True'' indica que el parqueadero es subterraneo y al marcarse como ''False'' el parqueadero se entiende que es por nivel de altura'
;

COMMENT ON COLUMN Parqueadero.q_cantidadNiveles
	IS 'Cantidad o n�mero de niveles que tiene el parqueadero, ya sean subterraneos o de altura'
;

COMMENT ON COLUMN Parqueadero.i_tipoSuelo
	IS 'El tipo de suelo es la caracteristica f�sica que tiene el parqueadero y puede tomar valores como: concreto asfalto  gravilla lavada de r�o compactada'
;

COMMENT ON COLUMN Parqueadero.i_factorDemandaZonal
	IS 'El factor de demanda que depende de la zona en que est� ubicado el aparcadero y/o estacionamiento y toma valores de 0.8 o 1.0 a partir de la demanda del sector, el estrato social y la actividad del sector'
;

COMMENT ON COLUMN Parqueadero.o_contrasenaParqueadero
	IS 'Se asignara una contrase�a unica a cada Parqueadero para el ingreso al sistema ''AparcApp'''
;

COMMENT ON COLUMN Parqueadero.i_estadoParqueadero
	IS 'El estado del parqueadero me permite saber si el parqueadero est� activo o no'
;

COMMENT ON TABLE Servicio
	IS 'Servicio almacena los periodos de tiempo y fechas en los cuales cada veh�culo utiliza un cupo del parqueadero y el valor a pagar'
;

COMMENT ON COLUMN Servicio.k_idServicio
	IS 'Atributo que permite identificar cada servicio realizado'
;

COMMENT ON COLUMN Servicio.f_ingreso
	IS 'Fecha en la que ingresa el veh�culo al Parqueadero'
;

COMMENT ON COLUMN Servicio.o_horaIngreso
	IS 'Hora en la que ingresa el veh�culo al Parqueadero'
;

COMMENT ON COLUMN Servicio.f_salida
	IS 'Fecha en la que se retira el veh�culo del Parqueadero'
;

COMMENT ON COLUMN Servicio.o_horaSalida
	IS 'Hora en la que sale el veh�culo del Parqueadero'
;

COMMENT ON COLUMN Servicio.v_pagoTotal
	IS 'Valor total a pagar '
;

COMMENT ON TABLE Tarifa
	IS 'Tarifa permite almacenar y calcular las tarifas que son manejadas por los Parqueaderos'
;

COMMENT ON COLUMN Tarifa.k_idTarifa
	IS 'C�digo unico para cada tarifa'
;

COMMENT ON COLUMN Tarifa.n_tipoVehiculo
	IS 'Nombre del tipo de vehiculo'
;

COMMENT ON COLUMN Tarifa.v_valorMaxMinuto
	IS 'Valor maximo por minuto '
;

COMMENT ON TABLE Vehiculo
	IS 'Veh�culo permite registrar cada uno de los veh�culos que ingresan al sistema y sus caracteristicas '
;

COMMENT ON COLUMN Vehiculo.k_placa
	IS 'Placa que permite identificar al veh�culo que utiliza el parqueadero'
;

COMMENT ON COLUMN Vehiculo.n_tipoVehiculo
	IS 'Nombre del tipo de veh�culo'
;

COMMENT ON COLUMN Vehiculo.n_marca
	IS 'Nombre de la marca del veh�culo, solo requerido si ingresa por contrato'
;

COMMENT ON COLUMN Vehiculo.n_color
	IS 'Nombre del color del veh�culo, solo requerido si ingresa por contrato'
;

COMMENT ON COLUMN Vehiculo.n_modelo
	IS 'Nombre del modelo del veh�culo, solo requerido si ingresa por contrato'
;
