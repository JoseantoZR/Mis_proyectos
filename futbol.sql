-- CREATE DATABASE futbol;

-- crear tablas
CREATE TABLE equipo (
    equipo_id INT PRIMARY KEY,
    nombre varchar(255) NOT NULL,
    categoria INT NOT NULL,
    f_fundacion DATE NOT NULL
);

CREATE TABLE jugador (
    jugador_id INT PRIMARY KEY,
    nombre VARCHAR(255),
    f_nacimiento DATE NOT NULL,
    posicion ENUM('PT','DFC','LD','LI','CAD','CAI','MI','MD','MC','MCD','MCO','EI','ED','DC'),
    equipo_id INT NULL,
    FOREIGN KEY (equipo_id) REFERENCES equipo(equipo_id)
);


-- insert filas
INSERT INTO equipo VALUES (1, 'Madrid', 1, '1902-03-06');
INSERT INTO equipo VALUES (2, 'Sevilla', 1, '1905-10-14');
INSERT INTO equipo VALUES (3, 'Barcelona', 1, '1904-07-29');
INSERT INTO equipo VALUES (4, 'Almería', 2, '2001-01-10');

INSERT INTO jugador (jugador_id, nombre, f_nacimiento, posicion, equipo_id) VALUES
(1, 'Courtois', '1992-05-11', 'PT', 1),
(2, 'Sergio Ramos', '1986-03-30', 'DFC', 1),
(3, 'Dani Carvajal', '1992-01-11', 'LD', 1),
(4, 'Luka Modric', '1985-09-09', 'MC', 1),
(5, 'Ter Stegen', '1992-04-30', 'PT', 3),
(6, 'Gerard Piqué', '1987-02-02', 'DFC', 3),
(7, 'Dani Olmo', '1998-05-07', 'MC', 3),
(8, 'Sergi Roberto', '1992-02-07', 'LD', 3),
(9, 'Jesus Navas', '1985-11-21', 'DFC', 2),
(10, 'Gonzalo Montiel', '1997-01-01', 'DFC', 2);


-- filtrado 
SELECT * FROM equipo WHERE categoria = 2;         -- selecciona todos los equipos de segunda división
SELECT * FROM jugador WHERE posicion = 'PT';      -- selecciona todos los porteros
SELECT COUNT(equipo_id) FROM equipo;              -- cuenta cuantos equipos hay en total
SELECT * FROM equipo WHERE f_fundacion            -- selecciona todos los equipos fundados en el siglo XX
    BETWEEN '1900-01-01' AND '1999-12-31';
SELECT * FROM jugador ORDER BY equipo_id ASC;     -- odena todos los jugadores por equipo
UPDATE jugador SET equipo_id = NULL               -- desvincula a un jugador de un equipo
    WHERE nombre='Dani Olmo';
UPDATE jugador SET equipo_id = NULL 
    WHERE nombre='Jesus Navas';
SELECT * FROM jugador WHERE equipo_id IS NULL;   -- muestra a los jugadores sin equipo
SELECT j.jugador_id, j.nombre, j.f_nacimiento, j.posicion, e.nombre AS equipo
    FROM jugador j JOIN equipo e ON j.equipo_id = e.equipo_id
    ORDER BY j.equipo_id ASC;                     -- ordena todos los jugadores por equipo pero reemplaza los numeros de id por el nombre