--UZMANLIK TABLOSU
CREATE TABLE uzmanlik (
	uzmanlik_id serial,
	alan varchar(50),
	PRIMARY KEY(uzmanlik_id)
);
--HASTANE TABLOSU
CREATE TABLE hastane (
	hastane_id serial,
	hastane_adi varchar(50),
	PRIMARY KEY(hastane_id)
);
--DOKTOR TABLOSU 
CREATE TABLE doktor (
	doktor_id serial,
	ad varchar(20) NOT NULL,
	soyad varchar(20) NOT NULL,
	PRIMARY KEY (doktor_id),
	doktor_uzm int NOT NULL,
	FOREIGN KEY (doktor_uzm) REFERENCES uzmanlik(uzmanlik_id),
	doktor_hast int NOT NULL,
	FOREIGN KEY (doktor_hast) REFERENCES hastane(hastane_id)
);
--TEDAVİ TABLOSU 
CREATE TABLE tedavi (
	tedavi_id serial,
	tip varchar(20),
	ilac text,
	ek varchar(20),
	PRIMARY KEY(tedavi_id)
);
--TAHLİL TABLOSU 
CREATE TABLE tahlil (
	tahlil_id serial,
	spirometre int,
	dif_test int,
	PRIMARY KEY (tahlil_id),
	CONSTRAINT spirometre_kisiti CHECK(spirometre > 0 AND spirometre < 100),
	CONSTRAINT difuzyon_kisiti CHECK (dif_test > 0 AND dif_test < 140)
);
--HASTA TABLOSU 
CREATE SEQUENCE hasta_seq START 1;

CREATE TABLE hasta (
	hasta_id int,
	ad varchar(20) NOT NULL,
	soyad varchar(20) NOT NULL,
	dtarih date NOT NULL,
	cinsiyet varchar(1) NOT NULL,
	h_tdv int,
	h_dktr int,
	h_thl int,
	FOREIGN KEY (h_tdv) REFERENCES tedavi(tedavi_id),
	FOREIGN KEY (h_dktr) REFERENCES doktor(doktor_id) ON DELETE SET NULL,
FOREIGN KEY (h_thl) REFERENCES tahlil(tahlil_id),
	PRIMARY KEY(hasta_id),
	CONSTRAINT yas_kisiti CHECK (dtarih < '2010-01-01'),
	CONSTRAINT cinsiyet_kisiti CHECK (cinsiyet = 'K' OR cinsiyet = 'E')
);

--ESKİ HASTA TABLOSU 
CREATE TABLE eski_hasta (
	hasta_id int NOT NULL,
	silme_tarihi text NOT NULL,
	ad varchar(20) NOT NULL,
	soyad varchar(20) NOT NULL,
	doktor_ad varchar(20) NOT NULL,
	doktor_soyad varchar(20) NOT NULL,
	PRIMARY KEY(hasta_id)
);
