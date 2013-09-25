/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : s74online

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2013-09-17 09:08:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s74_consumi`
-- ----------------------------
DROP TABLE IF EXISTS `s74_consumi`;
CREATE TABLE `s74_consumi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente_id` bigint(20) DEFAULT NULL,
  `codice` varchar(255) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `valore` float NOT NULL,
  `rivenditore_id` bigint(20) DEFAULT NULL,
  `cliente_descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_consumi
-- ----------------------------
INSERT INTO `s74_consumi` VALUES ('2', '3', null, '2013-08-06 02:00:00', null, '2013-08-06 23:03:54', '2013-08-06 23:03:54', '0', '1', '1', 'RICARICA', '100', '1', 'Ditta UNO');
INSERT INTO `s74_consumi` VALUES ('3', '4', null, '2013-08-06 02:00:00', null, '2013-08-06 23:09:25', '2013-08-06 23:09:25', '0', '1', '1', 'RICARICA', '150', '1', 'Studio74a');

-- ----------------------------
-- Table structure for `s74_contratti`
-- ----------------------------
DROP TABLE IF EXISTS `s74_contratti`;
CREATE TABLE `s74_contratti` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente_id` bigint(20) DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `licenza_numero` bigint(20) DEFAULT NULL,
  `linee` longtext,
  `rivenditore_id` bigint(20) DEFAULT NULL,
  `contratto_padre_id` bigint(20) DEFAULT NULL,
  `cliente_desc` varchar(255) DEFAULT NULL,
  `obsoleto` tinyint(1) DEFAULT NULL,
  `aggiornamento_attivo` tinyint(1) DEFAULT NULL,
  `canone_attivo` tinyint(1) DEFAULT NULL,
  `consumo_attivo` tinyint(1) DEFAULT NULL,
  `sospeso` tinyint(1) DEFAULT NULL,
  `consumo_data_fine` date DEFAULT NULL,
  `consumo_data_inizio` date DEFAULT NULL,
  `fitmato` tinyint(1) DEFAULT NULL,
  `versione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_contratti
-- ----------------------------
INSERT INTO `s74_contratti` VALUES ('1', '4', '2012-12-30', '2013-07-17', null, '2013-07-26 09:59:33', '2013-07-26 09:59:33', '0', '1', '1', '1', '[106, 127, 129]', '1', '0', 'Studio74a', '1', '0', '0', '0', '0', null, null, '0', null);
INSERT INTO `s74_contratti` VALUES ('2', '3', '2013-07-28', '2013-06-22', null, '2013-07-26 10:06:24', '2013-09-13 00:14:19', '0', '1', '1', '1', '[132]', '1', '0', 'Ditta UNO', '0', '1', '0', '0', '0', null, null, '0', null);
INSERT INTO `s74_contratti` VALUES ('3', '4', '2013-07-31', '2013-07-26', null, '2013-07-26 12:38:10', '2013-07-26 12:38:10', '0', '1', '1', '2', '[128]', '1', '0', 'Studio74a', '1', '0', '0', '0', '0', null, null, '0', null);
INSERT INTO `s74_contratti` VALUES ('4', '4', '2013-12-31', '2013-01-01', null, '2013-08-01 16:23:26', '2013-09-16 23:50:34', '0', '1', '1', '1', '[106, 127, 129]', '1', '1', 'Studio74a', '0', '0', '0', '0', '0', '2014-04-10', '2013-03-10', '0', null);
INSERT INTO `s74_contratti` VALUES ('5', '4', '2013-08-31', '2013-07-30', null, '2013-08-02 16:20:35', '2013-08-02 16:20:38', '0', '1', '1', '2', '[128]', '1', '3', 'Studio74a', '0', '0', '0', '0', '0', null, null, '0', null);

-- ----------------------------
-- Table structure for `s74_licenza_postazione`
-- ----------------------------
DROP TABLE IF EXISTS `s74_licenza_postazione`;
CREATE TABLE `s74_licenza_postazione` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente_desc` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `licenza_numero` bigint(20) DEFAULT NULL,
  `numero_postazioni` int(11) DEFAULT NULL,
  `rivenditore_id` bigint(20) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_licenza_postazione
-- ----------------------------
INSERT INTO `s74_licenza_postazione` VALUES ('8', null, '5', null, '2013-09-17 00:19:08', '2013-09-17 00:19:08', '0', '1', '1', '0', '50', '0', 'Terminal');

-- ----------------------------
-- Table structure for `s74_linee`
-- ----------------------------
DROP TABLE IF EXISTS `s74_linee`;
CREATE TABLE `s74_linee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codice` varchar(255) DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `moduli` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `gruppo` varchar(255) DEFAULT NULL,
  `posizioneBitChiave` int(11) NOT NULL,
  `idChiave` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_linee
-- ----------------------------
INSERT INTO `s74_linee` VALUES ('106', '', null, null, '2013-08-07 15:04:49', '0', '0', '1', '[7, 70, 73, 62]', 'LINEA1', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('107', null, null, null, null, null, null, null, null, 'LINEA15', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('108', null, null, null, null, null, null, null, null, 'LINEA19', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('109', null, null, null, null, null, null, null, null, 'LINEA31', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('110', null, null, null, null, null, null, null, null, 'LINEA33', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('111', null, null, null, null, null, null, null, null, 'LINEA35', 'Agenzia delle Entrate', '0', '0');
INSERT INTO `s74_linee` VALUES ('112', null, null, null, null, null, null, null, null, 'LINEA37', 'REGISTRAZIONI:', '0', '0');
INSERT INTO `s74_linee` VALUES ('113', null, null, null, null, null, null, null, null, 'LINEA47', 'REGISTRAZIONI:', '0', '0');
INSERT INTO `s74_linee` VALUES ('114', null, null, null, null, null, null, null, null, 'LINEA52', 'REGISTRAZIONI:', '0', '0');
INSERT INTO `s74_linee` VALUES ('115', null, null, null, null, null, null, null, null, 'LINEA62', 'REGISTRAZIONI:', '0', '0');
INSERT INTO `s74_linee` VALUES ('116', null, null, null, null, null, null, null, null, 'LINEA66', 'C.C.I.A.A.', '0', '0');
INSERT INTO `s74_linee` VALUES ('117', null, null, null, null, null, null, null, null, 'LINEA67', 'C.C.I.A.A.', '0', '0');
INSERT INTO `s74_linee` VALUES ('118', null, null, null, null, null, null, null, null, 'LINEA70', 'C.C.I.A.A.', '0', '0');
INSERT INTO `s74_linee` VALUES ('119', null, null, null, null, null, null, null, null, 'LINEA71', 'C.C.I.A.A.', '0', '0');
INSERT INTO `s74_linee` VALUES ('120', null, null, null, null, null, null, null, null, 'LINEA72', 'C.C.I.A.A.', '0', '0');
INSERT INTO `s74_linee` VALUES ('121', null, null, null, null, null, null, null, null, 'LINEA79', 'C.N.P.A.D.C.', '0', '0');
INSERT INTO `s74_linee` VALUES ('122', null, null, null, null, null, null, null, null, 'LINEA82', 'C.N.P.A.D.C.', '0', '0');
INSERT INTO `s74_linee` VALUES ('123', null, null, null, null, null, null, null, null, 'LINEA86', 'C.N.P.A.D.C.', '0', '0');
INSERT INTO `s74_linee` VALUES ('124', null, null, null, null, null, null, null, null, 'LINEA90', 'QUESTURA', '0', '0');
INSERT INTO `s74_linee` VALUES ('125', null, null, null, null, null, null, null, null, 'LINEA93', 'CONAI', '0', '0');
INSERT INTO `s74_linee` VALUES ('126', null, null, null, null, null, null, null, null, 'LINEA96', 'EQUITALIA', '0', '0');
INSERT INTO `s74_linee` VALUES ('127', null, null, null, null, null, null, null, null, 'LINEA105', 'GESTIONE COLLABORATORI (INAIL / INPS)', '0', '0');
INSERT INTO `s74_linee` VALUES ('128', null, null, null, null, null, null, null, null, 'LINEA115', 'INAIL', '0', '0');
INSERT INTO `s74_linee` VALUES ('129', null, null, null, null, null, null, null, null, 'LINEA117', 'INAIL', '0', '0');
INSERT INTO `s74_linee` VALUES ('130', null, null, null, null, null, null, null, null, 'LINEA129', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('131', null, null, null, null, null, null, null, null, 'LINEA131', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('132', null, null, null, null, null, null, null, null, 'LINEA133', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('133', null, null, null, null, null, null, null, null, 'LINEA139', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('134', null, null, null, null, null, null, null, null, 'LINEA141', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('135', null, null, null, null, null, null, null, null, 'LINEA142', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('136', null, null, null, null, null, null, null, null, 'LINEA143', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('137', null, null, null, null, null, null, null, null, 'LINEA145', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('138', null, null, null, null, null, null, null, null, 'LINEA155', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('139', null, null, null, null, null, null, null, null, 'LINEA157', 'INPS', '0', '0');
INSERT INTO `s74_linee` VALUES ('140', null, null, null, null, null, null, null, null, 'LINEA160', 'COLLOCAMENTO', '0', '0');
INSERT INTO `s74_linee` VALUES ('141', null, null, null, null, null, null, null, null, 'LINEA167', 'LOCAZIONI', '0', '0');
INSERT INTO `s74_linee` VALUES ('142', null, null, null, null, null, null, null, null, 'LINEA168', 'LOCAZIONI', '0', '0');
INSERT INTO `s74_linee` VALUES ('143', null, null, null, null, null, null, null, null, 'LINEA171', 'FATTURAZIONE DITTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('144', null, null, null, null, null, null, null, null, 'LINEA172', 'FATTURAZIONE DITTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('145', '', null, null, '2013-08-07 15:54:13', '0', '0', '1', '[74, 40]', 'LINEA173', 'FATTURAZIONE DITTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('146', null, null, null, null, null, null, null, null, 'LINEA174', 'FATTURAZIONE DITTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('147', null, null, null, null, null, null, null, null, 'LINEA175', 'FATTURAZIONE DITTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('148', null, null, null, null, null, null, null, null, 'LINEA178', 'POSTA & BANCA', '0', '0');
INSERT INTO `s74_linee` VALUES ('149', null, null, null, null, null, null, null, null, 'LINEA185', 'GESTIONI', '0', '0');
INSERT INTO `s74_linee` VALUES ('150', null, null, null, null, null, null, null, null, 'LINEA188', 'GESTIONI', '0', '0');
INSERT INTO `s74_linee` VALUES ('151', null, null, null, null, null, null, null, null, 'LINEA189', 'GESTIONI', '0', '0');
INSERT INTO `s74_linee` VALUES ('152', null, null, null, null, null, null, null, null, 'LINEA192', 'U.I.F.', '0', '0');
INSERT INTO `s74_linee` VALUES ('153', null, null, null, null, null, null, null, null, 'LINEA195', 'TRASFERIMENTO QUOTE', '0', '0');
INSERT INTO `s74_linee` VALUES ('154', null, null, null, null, null, null, null, null, 'LINEA198', 'FATTURAZIONE CONTO TERZI', '0', '0');
INSERT INTO `s74_linee` VALUES ('155', null, null, null, null, null, null, null, null, 'LINEA203', 'GESTIONE SUCCESSIONI', '0', '0');

-- ----------------------------
-- Table structure for `s74_moduli`
-- ----------------------------
DROP TABLE IF EXISTS `s74_moduli`;
CREATE TABLE `s74_moduli` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codice` varchar(255) DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valore` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_moduli
-- ----------------------------
INSERT INTO `s74_moduli` VALUES ('7', 'MODULO1', null, null, null, null, null, null, 'Adesione ai Processi Verbali di Constatazione e all\'invito al contraddittorio', '1');
INSERT INTO `s74_moduli` VALUES ('8', 'MODULO2', null, null, null, null, null, null, '       Atto Notorietà Autotrasportatori - Dichiarazione resa per beneficiare del credito d\'imposta', '1');
INSERT INTO `s74_moduli` VALUES ('9', 'MODULO3', null, null, null, null, null, null, '       Carichi Pendenti - Richiesta Certificazione dei Carichi Pendenti', '1');
INSERT INTO `s74_moduli` VALUES ('10', 'MODULO4', null, null, null, null, null, null, '       Cassetto Fiscale - Delega/Revoca ad un intermediario abilitato per l\'utilizzo del servizio', '1');
INSERT INTO `s74_moduli` VALUES ('11', 'MODULO5', null, null, null, null, null, null, '       Com. Anagrafe Tributaria Contr. Soc. Leasing e Operatori comm.li Att. Locaz. e/o Noleggio', '1');
INSERT INTO `s74_moduli` VALUES ('12', 'MODULO6', null, null, null, null, null, null, '       Com. dei dati relativi alle Persone Fisiche che hanno corrisposto Contributi Previdenziali', '1');
INSERT INTO `s74_moduli` VALUES ('13', 'MODULO7', null, null, null, null, null, null, '       Com. dei dati relativi alle Persone Fisiche che hanno corrisposto Interessi Passivi', '1');
INSERT INTO `s74_moduli` VALUES ('14', 'MODULO8', null, null, null, null, null, null, '       Com. dei dati relativi alle Persone Fisiche che hanno corrisposto Premi di Assicurazione', '1');
INSERT INTO `s74_moduli` VALUES ('15', 'MODULO9', null, null, null, null, null, null, '       Erogazioni Liberali - Comunicazione da parte di soggetti erogatori di erogazioni liberali', '1');
INSERT INTO `s74_moduli` VALUES ('16', 'MODULO10', null, null, null, null, null, null, '       Mod. ASR Aiuti di Stato - Dichiarazione per il recupero dell\'Aiuto di Stato - Rivalutazioni', '1');
INSERT INTO `s74_moduli` VALUES ('17', 'MODULO11', null, null, null, null, null, null, '       Modello per comunicare i dati relativi al Domicilio per la Notifica degli Atti', '1');
INSERT INTO `s74_moduli` VALUES ('18', 'MODULO12', null, null, null, null, null, null, '       PEC Grandi Contribuenti', '1');
INSERT INTO `s74_moduli` VALUES ('19', 'MODULO13', null, null, null, null, null, null, '       Responsabilità negli Appalti Edilizi DL 83/2012', '1');
INSERT INTO `s74_moduli` VALUES ('20', 'MODULO14', null, null, null, null, null, null, '       Richiesta di abilitazione al servizio telematico Entratel', '1');
INSERT INTO `s74_moduli` VALUES ('21', 'MODULO15', null, null, null, null, null, null, 'Certificazione dei Compensi e delle Provvigioni assoggettate a Ritenuta d\'Acconto', '1');
INSERT INTO `s74_moduli` VALUES ('22', 'MODULO16', null, null, null, null, null, null, '        Certificazione relativa agli Utili ed agli altri Proventi Equiparati corrisposti', '1');
INSERT INTO `s74_moduli` VALUES ('23', 'MODULO17', null, null, null, null, null, null, '        CUD - Certif. di cui all\'art. 4, commi 6-ter e 6-quater, D.P.R. 22 Luglio 1998, n. 322', '1');
INSERT INTO `s74_moduli` VALUES ('24', 'MODULO18', null, null, null, null, null, null, '        Iscrizione/Cancellazione VIES - Istanza per rich. inclusione o cancellazione Archivio VIES', '1');
INSERT INTO `s74_moduli` VALUES ('25', 'MODULO19', null, null, null, null, null, null, 'Comunicazione Annuale Dati IVA', '1');
INSERT INTO `s74_moduli` VALUES ('26', 'MODULO20', null, null, null, null, null, null, '        Comunicazione dell\'Opzione IRAP', '1');
INSERT INTO `s74_moduli` VALUES ('27', 'MODULO21', null, null, null, null, null, null, '        Comunicazione Definizione Versamenti e Carichi Iscritti a Ruolo Sospesi per Eventi Sismici', '1');
INSERT INTO `s74_moduli` VALUES ('28', 'MODULO22', null, null, null, null, null, null, '        Mod. CCN - Comunicazione relativa al Regime di Tassazione del Consolidato Nazionale', '1');
INSERT INTO `s74_moduli` VALUES ('29', 'MODULO23', null, null, null, null, null, null, '        Mod. EAS - Comunicazione dei dati rilevanti ai fini fiscali da parte degli Enti Associativi', '1');
INSERT INTO `s74_moduli` VALUES ('30', 'MODULO24', null, null, null, null, null, null, '        Mod. IRE - Interventi di Riqualificazione Energetica (Detrazione d\'Imposta del 55%)', '1');
INSERT INTO `s74_moduli` VALUES ('31', 'MODULO25', null, null, null, null, null, null, '        Mod. IVA 26LP - Prospetto delle Liquidazioni Periodiche', '1');
INSERT INTO `s74_moduli` VALUES ('32', 'MODULO26', null, null, null, null, null, null, '        Mod. IVA 79 - Istanza Rimborso Imposta sul Valore Aggiunto - Soggetti Non Residenti', '1');
INSERT INTO `s74_moduli` VALUES ('33', 'MODULO27', null, null, null, null, null, null, '        Mod. IVA TR - Richiesta rimborso o utilizzo in compensazione del Credito IVA Trimestrale', '1');
INSERT INTO `s74_moduli` VALUES ('34', 'MODULO28', null, null, null, null, null, null, '        Mod. SSP - Comunicazione dei compensi riscossi da parte delle Strutture Sanitarie Private', '1');
INSERT INTO `s74_moduli` VALUES ('35', 'MODULO29', null, null, null, null, null, null, '        Modelli Cartacei da Presentare Esclusivamente agli Sportelli dell\'Agenzia delle Entrate', '1');
INSERT INTO `s74_moduli` VALUES ('36', 'MODULO30', null, null, null, null, null, null, '        Modelli per la Richiesta di Accreditamento su C/C dei Rimborsi Fiscali', '1');
INSERT INTO `s74_moduli` VALUES ('37', 'MODULO31', null, null, null, null, null, null, 'Comunicazione dei Dati contenuti nelle Dichiarazioni di Intento Ricevute', '1');
INSERT INTO `s74_moduli` VALUES ('38', 'MODULO32', null, null, null, null, null, null, '        Dichiarazione di Intento ', '1');
INSERT INTO `s74_moduli` VALUES ('39', 'MODULO33', null, null, null, null, null, null, 'GestTel - Creazione file telematici multipli (AA7 - AA9 - ANR)', '1');
INSERT INTO `s74_moduli` VALUES ('40', 'MODULO34', null, null, null, null, null, null, '        GestTel F24 - Creazione file telematici multipli F24', '1');
INSERT INTO `s74_moduli` VALUES ('41', 'MODULO35', null, null, null, null, null, null, 'Modelli IVA (AA7 - AA9 - AA4 - AA5 - ANR - Richiesta di Certificato di Partita IVA - Tenuta Scritture', '1');
INSERT INTO `s74_moduli` VALUES ('42', 'MODULO36', null, null, null, null, null, null, '        Contabili)', '1');
INSERT INTO `s74_moduli` VALUES ('43', 'MODULO38', null, null, null, null, null, null, '        Cessione Fabbricato', '1');
INSERT INTO `s74_moduli` VALUES ('44', 'MODULO39', null, null, null, null, null, null, '        Locazione di Immobile Storico', '1');
INSERT INTO `s74_moduli` VALUES ('45', 'MODULO40', null, null, null, null, null, null, '        Mod. 1 - Denuncia di Contratto Verbale di locazione ed affitto beni immobili', '1');
INSERT INTO `s74_moduli` VALUES ('46', 'MODULO41', null, null, null, null, null, null, '        Mod. 69 - Richiesta di Registrazione (Lingua Tedesca)', '1');
INSERT INTO `s74_moduli` VALUES ('47', 'MODULO42', null, null, null, null, null, null, '        Mod. 69 - Richiesta di Registrazione e Adempimenti Successivi', '1');
INSERT INTO `s74_moduli` VALUES ('48', 'MODULO43', null, null, null, null, null, null, '        Mod. CDC - Comunicazione dati catastali', '1');
INSERT INTO `s74_moduli` VALUES ('49', 'MODULO44', null, null, null, null, null, null, '        Mod. RR - A/8 Richiesta Registrazione', '1');
INSERT INTO `s74_moduli` VALUES ('50', 'MODULO45', null, null, null, null, null, null, '        Mod. RR - A/8 Richiesta Registrazione (Lingua Tedesca)', '1');
INSERT INTO `s74_moduli` VALUES ('51', 'MODULO46', null, null, null, null, null, null, '        Mod. SIRIA - Contratti Locazione ad Uso Abitativo ed Esercizio Opzione per Cedolare Secca', '1');
INSERT INTO `s74_moduli` VALUES ('52', 'MODULO47', null, null, null, null, null, null, 'Mod. F23 - Modelli di Pagamento: tasse, imposte, sanzioni e altre entrate', '1');
INSERT INTO `s74_moduli` VALUES ('53', 'MODULO48', null, null, null, null, null, null, '        Mod. F23 (Lingua Tedesca)', '1');
INSERT INTO `s74_moduli` VALUES ('54', 'MODULO49', null, null, null, null, null, null, '        Mod. F23 (Lingua Slovena)', '1');
INSERT INTO `s74_moduli` VALUES ('55', 'MODULO50', null, null, null, null, null, null, '        F23 Istanza di Correzione', '1');
INSERT INTO `s74_moduli` VALUES ('56', 'MODULO51', null, null, null, null, null, null, '        Ravvedimento', '1');
INSERT INTO `s74_moduli` VALUES ('57', 'MODULO52', null, null, null, null, null, null, 'Mod. F24 - Modelli di pagamento unificato Telematico / Cartaceo', '1');
INSERT INTO `s74_moduli` VALUES ('58', 'MODULO53', null, null, null, null, null, null, '        Mod. F24 ACCISE - Modelli di pagamento unificato Telematico / Cartaceo', '1');
INSERT INTO `s74_moduli` VALUES ('59', 'MODULO54', null, null, null, null, null, null, '        Mod. F24 Semplificato - Modelli di pagamento unificato Cartaceo', '1');
INSERT INTO `s74_moduli` VALUES ('60', 'MODULO55', null, null, null, null, null, null, '        F24 Istanza di Correzione', '1');
INSERT INTO `s74_moduli` VALUES ('61', 'MODULO56', null, null, null, null, null, null, '        Mod. F24 Enti Pubblici - Modelli di pagamento Telematico', '1');
INSERT INTO `s74_moduli` VALUES ('62', 'MODULO57', null, null, null, null, null, null, '        Mod. F24 Versamenti elementi identificativi', '1');
INSERT INTO `s74_moduli` VALUES ('63', 'MODULO58', null, null, null, null, null, null, '        Annullamento del Modello F24 a Saldo Zero      ', '1');
INSERT INTO `s74_moduli` VALUES ('64', 'MODULO59', null, null, null, null, null, null, '        Autorizzazione / Revoca al Pagamento e trasmissione modelli F24', '1');
INSERT INTO `s74_moduli` VALUES ('65', 'MODULO60', null, null, null, null, null, null, '        Ravvedimento', '1');
INSERT INTO `s74_moduli` VALUES ('66', 'MODULO61', null, null, null, null, null, null, '        Richiesta di Rimborso delle Imposte di Registro/Ipotecarie/Catastali', '1');
INSERT INTO `s74_moduli` VALUES ('67', 'MODULO62', null, null, null, null, null, null, 'IVL Black List - Comunicazione Operazioni con Soggetti aventi Sede, Residenza o Domicilio in', '1');
INSERT INTO `s74_moduli` VALUES ('68', 'MODULO63', null, null, null, null, null, null, '        Paesi a Fiscalità Privilegiata', '1');
INSERT INTO `s74_moduli` VALUES ('69', 'MODULO66', null, null, null, null, null, null, 'Albo Gestori Ambientali', '1');
INSERT INTO `s74_moduli` VALUES ('70', 'MODULO67', null, null, null, null, null, null, 'Albo Imprese Artigiane', '1');
INSERT INTO `s74_moduli` VALUES ('71', 'MODULO68', null, null, null, null, null, null, '        Ruolo Conducenti', '1');
INSERT INTO `s74_moduli` VALUES ('72', 'MODULO69', null, null, null, null, null, null, '        S.C.I.A.', '1');
INSERT INTO `s74_moduli` VALUES ('73', 'MODULO70', null, null, null, null, null, null, 'Brevetti e Marchi', '1');
INSERT INTO `s74_moduli` VALUES ('74', 'MODULO71', null, null, null, null, null, null, 'Domanda di Carta Tachigrafica', '1');
INSERT INTO `s74_moduli` VALUES ('75', 'MODULO72', null, null, null, null, null, null, 'Pratiche Telematiche per il Registro Imprese (Specifiche Fedra 6.6.0)', '1');
INSERT INTO `s74_moduli` VALUES ('76', 'MODULO73', null, null, null, null, null, null, '        Albo Cooperative C17', '1');
INSERT INTO `s74_moduli` VALUES ('77', 'MODULO74', null, null, null, null, null, null, '        Mod. L2 - Bollatura e Numerazione dei Libri e delle Scritture Contabili obbligatori', '1');
INSERT INTO `s74_moduli` VALUES ('78', 'MODULO75', null, null, null, null, null, null, '        Richiesta Assegnazione / Convalida di Numero Meccanografico', '1');
INSERT INTO `s74_moduli` VALUES ('79', 'MODULO76', null, null, null, null, null, null, '        Direttiva Servizi (C32 - C33 - C34 - C35 - C36 - C37 - C38 - C39)', '1');
INSERT INTO `s74_moduli` VALUES ('80', 'MODULO79', null, null, null, null, null, null, 'Modulistica Cassa Nazionale di Previdenza e Assistenza dei Dottori Commercialisti', '1');
INSERT INTO `s74_moduli` VALUES ('81', 'MODULO82', null, null, null, null, null, null, 'Com Puglia', '1');
INSERT INTO `s74_moduli` VALUES ('82', 'MODULO83', null, null, null, null, null, null, '        Com Veneto', '1');
INSERT INTO `s74_moduli` VALUES ('83', 'MODULO84', null, null, null, null, null, null, '        S.C.I.A. Lombardia', '1');
INSERT INTO `s74_moduli` VALUES ('84', 'MODULO85', null, null, null, null, null, null, '        Modelli Nazionali', '1');
INSERT INTO `s74_moduli` VALUES ('85', 'MODULO86', null, null, null, null, null, null, 'Dichiarazione IMU - Imposta Municipale Propria', '1');
INSERT INTO `s74_moduli` VALUES ('86', 'MODULO87', null, null, null, null, null, null, '        Rimborso ICI - Istanza di Rimborso ICI', '1');
INSERT INTO `s74_moduli` VALUES ('87', 'MODULO90', null, null, null, null, null, null, 'Modulistica Questura', '1');
INSERT INTO `s74_moduli` VALUES ('88', 'MODULO93', null, null, null, null, null, null, 'Modulistica Conai', '1');
INSERT INTO `s74_moduli` VALUES ('89', 'MODULO96', null, null, null, null, null, null, 'Atto di Delega per Richiesta di Rateazione', '1');
INSERT INTO `s74_moduli` VALUES ('90', 'MODULO97', null, null, null, null, null, null, '        Autocertificazione per Cancellare il Ruolo', '1');
INSERT INTO `s74_moduli` VALUES ('91', 'MODULO98', null, null, null, null, null, null, '        Dichiarazione di avvenuta Compensazione e/o Richiesta di Imputazione dei Pagamenti', '1');
INSERT INTO `s74_moduli` VALUES ('92', 'MODULO99', null, null, null, null, null, null, '        Domanda di Rimborso della Cartella Esattoriale', '1');
INSERT INTO `s74_moduli` VALUES ('93', 'MODULO100', null, null, null, null, null, null, '        Domanda di Sgravio/Correzione', '1');
INSERT INTO `s74_moduli` VALUES ('94', 'MODULO101', null, null, null, null, null, null, '        Sospensione della Riscossione di Cartelle di Pagamento', '1');
INSERT INTO `s74_moduli` VALUES ('95', 'MODULO102', null, null, null, null, null, null, '        Modulistica Equitalia', '1');
INSERT INTO `s74_moduli` VALUES ('96', 'MODULO105', null, null, null, null, null, null, 'Iscrizione / Variazione INAIL', '1');
INSERT INTO `s74_moduli` VALUES ('97', 'MODULO106', null, null, null, null, null, null, '        Variazione / Cancellazione INPS', '1');
INSERT INTO `s74_moduli` VALUES ('98', 'MODULO107', null, null, null, null, null, null, '        Dichiarazione superamento del limite di 5000 euro per i Collaboratori occasionali', '1');
INSERT INTO `s74_moduli` VALUES ('99', 'MODULO108', null, null, null, null, null, null, '        SC04 Iscrizione GS - Domanda di Iscrizione alla Gestione Separata', '1');
INSERT INTO `s74_moduli` VALUES ('100', 'MODULO109', null, null, null, null, null, null, '        SC05 Mod. O10/M/02 - Domanda di Autorizzazione alla Prosecuzione Volontaria', '1');
INSERT INTO `s74_moduli` VALUES ('101', 'MODULO110', null, null, null, null, null, null, '        SC52 Mod. Rimb. Lav. Occ. - Rich. rimb. buoni lavoro occasionale accessorio non utilizzati', '1');
INSERT INTO `s74_moduli` VALUES ('102', 'MODULO111', null, null, null, null, null, null, '        SC53 Delega Lav. Occ. - Delega per utilizzo procedure per il Lavoro Occasionale Accessorio', '1');
INSERT INTO `s74_moduli` VALUES ('103', 'MODULO112', null, null, null, null, null, null, '        SR06 Mod. MAL./GEST. SEP. - Indennità degenza ospedaliera - Lav. autonomi Gest. Sep.', '1');
INSERT INTO `s74_moduli` VALUES ('104', 'MODULO115', null, null, null, null, null, null, 'Denunce Infortuni sul lavoro / Malattie Professionali', '1');
INSERT INTO `s74_moduli` VALUES ('105', 'MODULO116', null, null, null, null, null, null, '        Denuncia di Nuovo Lavoro Temporaneo', '1');
INSERT INTO `s74_moduli` VALUES ('106', 'MODULO117', null, null, null, null, null, null, 'Comunicazione Unica sez. INAIL', '1');
INSERT INTO `s74_moduli` VALUES ('107', 'MODULO118', null, null, null, null, null, null, '        Quadri, Denunce, Istanze, Modelli OT', '1');
INSERT INTO `s74_moduli` VALUES ('108', 'MODULO119', null, null, null, null, null, null, '        Denuncia Nominativa Assicurati Soci/Collaboratori/Coadiuvanti', '1');
INSERT INTO `s74_moduli` VALUES ('109', 'MODULO120', null, null, null, null, null, null, '        Autocertificazione / Dichiarazione Sostitutiva - Premi', '1');
INSERT INTO `s74_moduli` VALUES ('110', 'MODULO121', null, null, null, null, null, null, '        Denuncia Lavoro Occasionale - Com. Preventiva Prestazioni Occasionali Lavoro Accessorio', '1');
INSERT INTO `s74_moduli` VALUES ('111', 'MODULO122', null, null, null, null, null, null, '        Variazione Lavoro Occasionale - Com. Preventiva Prestazioni Occasionali di tipo Accessorio', '1');
INSERT INTO `s74_moduli` VALUES ('112', 'MODULO123', null, null, null, null, null, null, '        Libro Unico del Lavoro - Rich. Autorizz. Stampa e Generazione Numerazione Automatica', '1');
INSERT INTO `s74_moduli` VALUES ('113', 'MODULO124', null, null, null, null, null, null, '        Libro Unico del Lavoro - Ditta - Stampa Laser Richiesta di Autorizzazione', '1');
INSERT INTO `s74_moduli` VALUES ('114', 'MODULO125', null, null, null, null, null, null, '        Libro Unico del Lavoro - Intermediario - Stampa Laser Richiesta di Autorizzazione', '1');
INSERT INTO `s74_moduli` VALUES ('115', 'MODULO126', null, null, null, null, null, null, '        Rappresentanti dei Lavoratori per la Sicurezza', '1');
INSERT INTO `s74_moduli` VALUES ('116', 'MODULO129', null, null, null, null, null, null, 'Assegno per il Nucleo Familiare (AP61, AP62, AP63, SR03, SR15, SR16, SR25, SR27, SR28, SR32,  ', '1');
INSERT INTO `s74_moduli` VALUES ('117', 'MODULO130', null, null, null, null, null, null, '        SR35, SR56, SR61, SR65, SR70)', '1');
INSERT INTO `s74_moduli` VALUES ('118', 'MODULO131', null, null, null, null, null, null, 'CIG Telematico (Procedura automatizzata per Pagamento diretto da parte dell\'INPS)', '1');
INSERT INTO `s74_moduli` VALUES ('119', 'MODULO132', null, null, null, null, null, null, '       CIG Straordinario e in Deroga Telematico', '1');
INSERT INTO `s74_moduli` VALUES ('120', 'MODULO133', null, null, null, null, null, null, 'Comunicazione Unica sez. INPS', '1');
INSERT INTO `s74_moduli` VALUES ('121', 'MODULO134', null, null, null, null, null, null, '       SC00 - Modulo per l\'invio di documenti aziendali', '1');
INSERT INTO `s74_moduli` VALUES ('122', 'MODULO135', null, null, null, null, null, null, '       SC11 Mod. Rid. Sanz. - Domanda di Riduzione delle Sanzioni Civili', '1');
INSERT INTO `s74_moduli` VALUES ('123', 'MODULO136', null, null, null, null, null, null, '       SC36 - Aiuti di Stato - Dichiarazione ai fini dell\'accesso', '1');
INSERT INTO `s74_moduli` VALUES ('124', 'MODULO137', null, null, null, null, null, null, '       Mod. C.D. 1 (Iscrizione, Variazione, Cessazione)', '1');
INSERT INTO `s74_moduli` VALUES ('125', 'MODULO138', null, null, null, null, null, null, '       Mod. I.A.P. 1 (Iscrizione, Variazione, Cessazione)', '1');
INSERT INTO `s74_moduli` VALUES ('126', 'MODULO139', null, null, null, null, null, null, 'DMAG - Dichiarazione di Manodopera Agricola Trimestrale', '1');
INSERT INTO `s74_moduli` VALUES ('127', 'MODULO140', null, null, null, null, null, null, '       Richiesta di assegnazione PIN (Personal Identification Number)', '1');
INSERT INTO `s74_moduli` VALUES ('128', 'MODULO141', null, null, null, null, null, null, 'Fondo di Garanzia (SR22, SR30, SR50, SR52, SR53, SR75, SR93, SR94, SR95, SR96, SR97, SR98)', '1');
INSERT INTO `s74_moduli` VALUES ('129', 'MODULO142', null, null, null, null, null, null, 'Indennità di Disoccupazione (SR04, SR05, SR17, SR18, SR24, SR37, SR58, SR72, SR92, SR105)', '1');
INSERT INTO `s74_moduli` VALUES ('130', 'MODULO143', null, null, null, null, null, null, 'Integrazioni Salariali (SR00, SR21, SR33, SR38, SR40, SR41, SR42, SR43, SR45-SR46, SR49, SR78,', '1');
INSERT INTO `s74_moduli` VALUES ('131', 'MODULO144', null, null, null, null, null, null, '       SR89, SR100)', '1');
INSERT INTO `s74_moduli` VALUES ('132', 'MODULO145', null, null, null, null, null, null, 'Maternità / Malattia', '1');
INSERT INTO `s74_moduli` VALUES ('133', 'MODULO146', null, null, null, null, null, null, '        Prestazioni temporanee (SC13, SC15, SC16, SC17, SC31, SC46)', '1');
INSERT INTO `s74_moduli` VALUES ('134', 'MODULO147', null, null, null, null, null, null, '        MV01 - Modulo Reclamo', '1');
INSERT INTO `s74_moduli` VALUES ('135', 'MODULO148', null, null, null, null, null, null, '        MV06 Mod. Rich/L.241 - Richiesta di Accesso ai documenti amministrativi', '1');
INSERT INTO `s74_moduli` VALUES ('136', 'MODULO149', null, null, null, null, null, null, '        MV10 Modello Detrazioni - Dichiarazione Annuale per il Diritto alle Detrazioni d\'Imposta', '1');
INSERT INTO `s74_moduli` VALUES ('137', 'MODULO150', null, null, null, null, null, null, '        MV35 - Richiesta Assegnazione PIN per il cittadino', '1');
INSERT INTO `s74_moduli` VALUES ('138', 'MODULO151', null, null, null, null, null, null, '        SC62 - Richiesta Assegnazione PIN Sub-Delegati', '1');
INSERT INTO `s74_moduli` VALUES ('139', 'MODULO152', null, null, null, null, null, null, '        SC63 - Richiesta Assegnazione PIN Intermediario Associazioni', '1');
INSERT INTO `s74_moduli` VALUES ('140', 'MODULO153', null, null, null, null, null, null, '        SC64 - Richiesta Assegnazione PIN Intermediario Abilitato', '1');
INSERT INTO `s74_moduli` VALUES ('141', 'MODULO154', null, null, null, null, null, null, '        SC65 - Richiesta Assegnazione PIN Datore di Lavoro', '1');
INSERT INTO `s74_moduli` VALUES ('142', 'MODULO155', null, null, null, null, null, null, 'Mod. D.A. - Denuncia Aziendale Agricoli ex art. 5 Decreto Legislativo n. 375/93', '1');
INSERT INTO `s74_moduli` VALUES ('143', 'MODULO156', null, null, null, null, null, null, '        Mod. R.I. Agricoli Registro di Impresa (SC41, SC42-SC43)', '1');
INSERT INTO `s74_moduli` VALUES ('144', 'MODULO157', null, null, null, null, null, null, 'Arco (SC01, SC02, Arco Var, Arco Col, Arco Ces)', '1');
INSERT INTO `s74_moduli` VALUES ('145', 'MODULO160', null, null, null, null, null, null, 'Modulistica Collocamento', '1');
INSERT INTO `s74_moduli` VALUES ('146', 'MODULO161', null, null, null, null, null, null, '       Collocamento Telematico', '1');
INSERT INTO `s74_moduli` VALUES ('147', 'MODULO162', null, null, null, null, null, null, '       SC34 T.F.R. Tesoreria', '1');
INSERT INTO `s74_moduli` VALUES ('148', 'MODULO163', null, null, null, null, null, null, '       SC50', '1');
INSERT INTO `s74_moduli` VALUES ('149', 'MODULO164', null, null, null, null, null, null, '       SC51', '1');
INSERT INTO `s74_moduli` VALUES ('150', 'MODULO167', null, null, null, null, null, null, 'Gestione Locazioni (Contratti d\'Affitto, Fondi Rustici Tel. Annuali, Calcolo di Convenienza)', '1');
INSERT INTO `s74_moduli` VALUES ('151', 'MODULO168', null, null, null, null, null, null, 'Calcolo di Convenienza per l\'esercizio dell\'Opzione per la Cedolare Secca', '1');
INSERT INTO `s74_moduli` VALUES ('152', 'MODULO171', null, null, null, null, null, null, 'Proforma (Gestione Proforme) - WinParc (Gestione Fatture/Parcelle)', '1');
INSERT INTO `s74_moduli` VALUES ('153', 'MODULO172', null, null, null, null, null, null, 'Incassi Elettronici (Gestione RI.BA. e R.I.D.)', '1');
INSERT INTO `s74_moduli` VALUES ('154', 'MODULO173', null, null, null, null, null, null, 'Nota Spese', '1');
INSERT INTO `s74_moduli` VALUES ('155', 'MODULO174', null, null, null, null, null, null, 'Certificazione Compensi collegato alla Fatturazione', '1');
INSERT INTO `s74_moduli` VALUES ('156', 'MODULO175', null, null, null, null, null, null, 'DDT (Documenti di Trasporto) - FCT DDT (Documenti di Trasporto Conto Terzi)', '1');
INSERT INTO `s74_moduli` VALUES ('157', 'MODULO178', null, null, null, null, null, null, 'Cambiali', '1');
INSERT INTO `s74_moduli` VALUES ('158', 'MODULO179', null, null, null, null, null, null, '       CCB Conti Correnti Bancari', '1');
INSERT INTO `s74_moduli` VALUES ('159', 'MODULO180', null, null, null, null, null, null, '       CCP Conti Correnti Postali', '1');
INSERT INTO `s74_moduli` VALUES ('160', 'MODULO181', null, null, null, null, null, null, '       Servizi Bancari', '1');
INSERT INTO `s74_moduli` VALUES ('161', 'MODULO182', null, null, null, null, null, null, '       Servizi Postali (Circolari, Protocollo Corrispondenza, Spedizioni)', '1');
INSERT INTO `s74_moduli` VALUES ('162', 'MODULO185', null, null, null, null, null, null, 'Trasmissione Telematica dei dati relativi a Forniture di Documenti Fiscali', '1');
INSERT INTO `s74_moduli` VALUES ('163', 'MODULO186', null, null, null, null, null, null, '        Richiesta Consegna Stampati Prenumerati', '1');
INSERT INTO `s74_moduli` VALUES ('164', 'MODULO187', null, null, null, null, null, null, '        Richiesta di Autorizzazione alla Stampa e alla Rivendita di Documenti Fiscali', '1');
INSERT INTO `s74_moduli` VALUES ('165', 'MODULO188', null, null, null, null, null, null, 'Redditometro (Calcolo Reddito minimo presunto sulla base degli indici di capacità contributiva)', '1');
INSERT INTO `s74_moduli` VALUES ('166', 'MODULO189', null, null, null, null, null, null, 'Richiesta Fido e/o Finanziamento', '1');
INSERT INTO `s74_moduli` VALUES ('167', 'MODULO192', null, null, null, null, null, null, 'Unità di Informazione Finanziaria (ex Ufficio Italiano Cambi)', '1');
INSERT INTO `s74_moduli` VALUES ('168', 'MODULO195', null, null, null, null, null, null, 'Trasferimento Quote (IL MODELLO NON FA PARTE DEL PACCHETTO COMPLETO)', '1');
INSERT INTO `s74_moduli` VALUES ('169', 'MODULO198', null, null, null, null, null, null, 'Fatturazione Conto Terzi (IL MODELLO NON FA PARTE DEL PACCHETTO COMPLETO)', '1');
INSERT INTO `s74_moduli` VALUES ('170', 'MODULO199', null, null, null, null, null, null, '       Fct Proforma - Gestione Proforme Conto Terzi', '1');
INSERT INTO `s74_moduli` VALUES ('171', 'MODULO200', null, null, null, null, null, null, '       Fct WinParc - Gestione Fatture/Parcelle Conto Terzi', '1');
INSERT INTO `s74_moduli` VALUES ('172', 'MODULO203', null, null, null, null, null, null, 'Gestione delle Dichiarazioni di Successione (IL MODELLO NON FA PARTE DEL PACCHETTO COMPLETO)', '1');

-- ----------------------------
-- Table structure for `s74_nominativi`
-- ----------------------------
DROP TABLE IF EXISTS `s74_nominativi`;
CREATE TABLE `s74_nominativi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codice` varchar(255) DEFAULT NULL,
  `codice_fiscale` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `contatto_padre_id` bigint(20) DEFAULT NULL,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `gruppi` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nome_visualizzato` varchar(255) DEFAULT NULL,
  `note` longtext,
  `partita_iva` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ragione_sociale` varchar(255) DEFAULT NULL,
  `rivenditore_id` bigint(20) DEFAULT NULL,
  `ruoli` varchar(255) DEFAULT NULL,
  `titolo` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sito` varchar(255) DEFAULT NULL,
  `indirizzo_cap` varchar(255) DEFAULT NULL,
  `indirizzo_comune` varchar(255) DEFAULT NULL,
  `indirizzo_prov` varchar(255) DEFAULT NULL,
  `indirizzo_via` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_nominativi
-- ----------------------------
INSERT INTO `s74_nominativi` VALUES ('1', null, null, 'S74', '0', null, '2013-07-05 16:10:49', '2013-07-05 16:10:49', '0', '1', '0', null, 'Admin', 'S74 Admin', null, null, 'admin', null, '1', 'UTENTE', null, 'admin', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `s74_nominativi` VALUES ('2', '1', null, null, '0', null, '2013-07-05 16:10:49', '2013-07-05 16:10:49', '0', '1', '1', null, null, 'PREDEFINITO', null, null, null, 'PREDEFINITO', '1', 'RIVENDITORE', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `s74_nominativi` VALUES ('3', '1445', null, null, '0', null, '2013-07-05 16:12:34', '2013-09-17 00:35:47', '0', '1', '1', null, null, 'Ditta UNO', '', '123456789123', null, 'Ditta UNO', '1', 'CONTATTO', null, null, '0445111222', '', '1', 'www.attocchi.it', 'mirco@attocchi.it', '36030', 'Caltrano', 'VI', 'via Santa Rosa, 44', '3479096907');
INSERT INTO `s74_nominativi` VALUES ('4', '1288', null, null, '0', null, '2013-07-26 10:34:28', '2013-09-13 08:12:47', '0', '1', '1', null, null, 'Studio74a', '', '123', null, 'Studio74a', '1', 'CONTATTO', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `s74_nominativi` VALUES ('5', '1030', null, null, '0', null, '2013-09-16 18:09:55', '2013-09-17 00:36:02', '0', '1', '1', null, null, 'Mirco Attocchi', null, '0315477889255', null, 'Mirco Attocchi', '1', 'CONTATTO', null, null, '', '', '1', 'mirco@attocchi.it', 'www.attocchi.it', '36030', 'Caltrano', 'VI', 'via CittÃ  d\'Alba, 11', '347-9096907');

-- ----------------------------
-- Table structure for `s74_note`
-- ----------------------------
DROP TABLE IF EXISTS `s74_note`;
CREATE TABLE `s74_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_cancellazione` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_modifica` datetime DEFAULT NULL,
  `utente_cancellazione_id` bigint(20) DEFAULT NULL,
  `utente_creazione_id` bigint(20) DEFAULT NULL,
  `utente_modifica_id` bigint(20) DEFAULT NULL,
  `nota` longtext,
  `oggetto` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `oggettoId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s74_note
-- ----------------------------
INSERT INTO `s74_note` VALUES ('1', null, '2013-09-17 08:05:33', '2013-09-17 08:05:33', '0', '1', '1', 'erg tr', 'it.attocchi.studio74.online.entities.Nominativo', 'NOTA', '4');
INSERT INTO `s74_note` VALUES ('2', null, '2013-09-17 08:31:06', '2013-09-17 08:31:12', '0', '1', '1', 'Nota per l\'assistenza', 'it.attocchi.studio74.online.entities.Nominativo', 'ASSISTENZA', '4');
INSERT INTO `s74_note` VALUES ('3', null, '2013-09-17 08:31:42', '2013-09-17 08:31:42', '0', '1', '1', 'nota generale', 'it.attocchi.studio74.online.entities.Nominativo', 'NOTA', '4');
