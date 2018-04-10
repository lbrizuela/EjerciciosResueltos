----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
select persona.tipodoc , persona.documento, persona.nombre, persona.apellido, alumno.legajo 
from persona inner join alumno on alumno.idpersona = persona.identificador

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente

select alumno.legajo, persona.nombre, persona.apellido, carrera.nombre, inscripciones_carrera.fechainscripcion
from inscripciones_carrera inner join alumno on alumno.identificador= inscripciones_carrera.idalumno
inner join persona on alumno.idpersona = persona.identificador 
inner join carrera on carrera.identificador = inscripciones_carrera.idcarrera
order by alumno.legajo  desc


--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso

select carrera.nombre as nombrecarrea  , curso.nombre  as nombrecurso, count(inscripciones_curso.idcurso) as cantidad_inscriptos, curso.cupomaximo
from curso inner join carrera on carrera.identificador = curso.idcarrera
inner join inscripciones_curso on inscripciones_curso.idcurso = curso.identificador
group by  carrera.identificador , curso.identificador

--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo

select carrera.nombre as nombrecarrea  , curso.nombre  as nombrecurso, count(inscripciones_curso.idcurso) as cantidad_inscriptos, curso.cupomaximo
from curso inner join carrera on carrera.identificador = curso.idcarrera
inner join inscripciones_curso on inscripciones_curso.idcurso = curso.identificador
group by  carrera.identificador , curso.identificador
HAVING count(inscripciones_curso.idcurso) > curso.cupomaximo  


--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.

select  * from curso

UPDATE curso
    SET cupomaximo = 10
    WHERE curso.cupomaximo < 5
	and curso.anio = 2018





--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual

select DISTINCT alumno.legajo , carrera.nombre,  inscripciones_carrera.fechainscripcion as fecha_carrera ,curso.nombre,  inscripciones_curso.fechainscripcion
from alumno inner join inscripciones_carrera on inscripciones_carrera.idalumno= alumno.identificador
inner join inscripciones_curso on inscripciones_curso.idalumno = alumno.identificador
inner join carrera on carrera.identificador = inscripciones_carrera.idcarrera
inner join curso on curso.idcarrera = inscripciones_carrera.idcarrera
and inscripciones_curso.idcurso= curso.identificador
where inscripciones_carrera.fechainscripcion > inscripciones_curso.fechainscripcion

UPDATE  inscripciones_curso
SET fechainscripcion = NOW()
FROM  (select DISTINCT alumno.legajo ,  inscripciones_carrera.fechainscripcion as fecha_carrera ,  inscripciones_curso.fechainscripcion
	,inscripciones_curso.idcurso, inscripciones_curso.idalumno
	   from alumno inner join inscripciones_carrera on inscripciones_carrera.idalumno= alumno.identificador
	inner join inscripciones_curso on inscripciones_curso.idalumno = alumno.identificador
	inner join curso on curso.idcarrera = inscripciones_carrera.idcarrera
	and inscripciones_curso.idcurso= curso.identificador
	where inscripciones_carrera.fechainscripcion > inscripciones_curso.fechainscripcion
    order by inscripciones_curso.idcurso, inscripciones_curso.idalumno			)  tabla2agregada
where inscripciones_curso.idcurso =tabla2agregada.idcurso
and inscripciones_curso.idalumno = tabla2agregada.idalumno


--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)


insert into persona (identificador, tipodoc, documento,nombre,apellido,fechanac) values ((SELECT Max( identificador) FROM persona )+1,'DNI', 37279593,'Luisina', 'Brizuela', '1994-03-07' )

INSERT INTO alumno ( identificador,idpersona, legajo)
     VALUES ((SELECT Max( identificador) FROM alumno )+1,(SELECT identificador  FROM persona where documento = 37279593 ), 40133);
--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.

ALTER TABLE persona
  ADD direccion VARCHAR(200);

select * from persona


