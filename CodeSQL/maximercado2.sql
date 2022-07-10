-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-07-2022 a las 02:43:51
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `maximercado2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `idCarrito` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `precio` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `Nombre` varchar(15) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(15) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `CodigoBarras` varchar(30) NOT NULL,
  `Stock` varchar(30) NOT NULL,
  `idCategoria` varchar(30) NOT NULL,
  `Precio` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `Nombre`, `CodigoBarras`, `Stock`, `idCategoria`, `Precio`) VALUES
(1, 'Coca-Cola', '1314', '200', '1', '299'),
(2, 'Galletas', '3322', '100', '2', '150'),
(3, 'Yogurt', '2313', '100', '3', '200'),
(4, 'Leche', '3343', '100', '4', '190'),
(5, 'Detergente', '2344', '100', '5', '130'),
(8, 'Alcohol', '3333', '100', '6', '280'),
(9, 'Azucar', '444', '100', '7', '200'),
(10, 'Harina', '555', '420', '6', '260'),
(11, 'Tomates', '566', '50', '8', '220'),
(12, 'Pepsi', '456', '100', '1', '200');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosseleccionados`
--

CREATE TABLE `productosseleccionados` (
  `idCarrito` int(15) NOT NULL,
  `count` int(15) NOT NULL,
  `idUsuario` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `EsFrecuente` tinyint(1) NOT NULL,
  `idRol` int(11) DEFAULT NULL,
  `idDomicilio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `dni`, `correo`, `pass`, `EsFrecuente`, `idRol`, `idDomicilio`) VALUES
(4, 'Ignacio', 'Salto', '42552612', 'admin', 'admin', 0, 1, 0),
(6, 'Juan', 'Perez', '23456678', 'cliente', 'cliente', 1, 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`idCarrito`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `productosseleccionados`
--
ALTER TABLE `productosseleccionados`
  ADD PRIMARY KEY (`count`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `productosseleccionados`
--
ALTER TABLE `productosseleccionados`
  MODIFY `count` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
