-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 03 Lip 2015, 19:00
-- Wersja serwera: 5.6.24
-- Wersja PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `testdb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `lekarz`
--

CREATE TABLE IF NOT EXISTS `lekarz` (
  `ID` int(5) NOT NULL,
  `Imię` varchar(20) NOT NULL,
  `Nazwisko` varchar(20) NOT NULL,
  `Specjalizacja` varchar(30) NOT NULL,
  `NrPokoju` int(5) NOT NULL,
  `Opis` varchar(100) NOT NULL,
  `LiczbaOcen` int(20) NOT NULL,
  `SumaOcen` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `lekarz`
--

INSERT INTO `lekarz` (`ID`, `Imię`, `Nazwisko`, `Specjalizacja`, `NrPokoju`, `Opis`, `LiczbaOcen`, `SumaOcen`) VALUES
(123, 'Janusz', 'Januszewski', 'okulista', 1, 'Jestem okulista', 9, 31);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pacjent`
--

CREATE TABLE IF NOT EXISTS `pacjent` (
  `Imię` varchar(20) NOT NULL,
  `Nazwisko` varchar(20) NOT NULL,
  `PESEL` varchar(12) NOT NULL,
  `Ulica` varchar(30) NOT NULL,
  `NrUlicy` int(5) NOT NULL,
  `NrDomu` int(5) NOT NULL,
  `Miejscowość` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `pacjent`
--

INSERT INTO `pacjent` (`Imię`, `Nazwisko`, `PESEL`, `Ulica`, `NrUlicy`, `NrDomu`, `Miejscowość`) VALUES
('Kuba', 'Janiec', '12345678909', 'Poniatowskiego', 1, 2, 'Stalowa Wola'),
('Marek', 'Fortuna', '48392037546', 'budryka', 2, 2, 'Kraków'),
('Zbyszek', 'Nowak', '84385746125', 'Kwiatowa', 54, 2, 'Lublin'),
('Janusz', 'Kot', '89120125336', 'Slowackiego', 2, 53, 'Kraków'),
('Marzena', 'Kowalska', '90030514847', 'Mickiewicza', 23, 43, 'Warszawa'),
('Jerzy', 'Nowak', '93070204058', 'Mozarta', 2, 43, 'Nisko'),
('Jakub', 'Janiec', '93113001516', 'Poniatowskiego', 74, 26, 'Stalowa Wola');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pass`
--

CREATE TABLE IF NOT EXISTS `pass` (
  `login` varchar(10) NOT NULL,
  `haslo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `pass`
--

INSERT INTO `pass` (`login`, `haslo`) VALUES
('dynsa', 'asnyd'),
('kar', 'gar');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `pacjent`
--
ALTER TABLE `pacjent`
  ADD PRIMARY KEY (`PESEL`);

--
-- Indexes for table `pass`
--
ALTER TABLE `pass`
  ADD UNIQUE KEY `login` (`login`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
