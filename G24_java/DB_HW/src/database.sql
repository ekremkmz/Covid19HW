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
-- INSERT INTO LAR
--uzmanlık
INSERT INTO uzmanlik(alan) VALUES ('Aile');
INSERT INTO uzmanlik(alan) VALUES ('Kardiyoloji');
INSERT INTO uzmanlik(alan) VALUES ('Göğüs Hastalıkları');
INSERT INTO uzmanlik(alan) VALUES ('Yoğun Bakım');
INSERT INTO uzmanlik(alan) VALUES ('Nöroloji');
--hastane
INSERT INTO hastane(hastane_adi) VALUES ('Asrın Hastanesi');
INSERT INTO hastane(hastane_adi) VALUES ('Berhayat Hastanesi');
INSERT INTO hastane(hastane_adi) VALUES ('Gebze Anadolu Sağlık Merkezi');
INSERT INTO hastane(hastane_adi) VALUES ('Sipahi Hastanesi');
INSERT INTO hastane(hastane_adi) VALUES ('Şişli Etfal Hastanesi');
--doktor
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Eren', 'Akyürek', 1, 3);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Ayşenur', 'Torun', 1, 4);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Mehmet', 'Kasap', 4,1);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Emre', 'Yaman', 2, 1 );
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Elif', 'Yiğit', 4, 1);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Ada', 'Çelik', 5, 2);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Kübra', 'Güney', 1, 4 );
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Yunus', 'Balcı', 2, 3);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Oya', 'Işık', 5, 4);
INSERT INTO doktor(ad, soyad, doktor_uzm, doktor_hast) VALUES ('Can', 'Amasyalı', 3, 2);
--tedavi
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Yoğun Bakım', 'Deksametazon, Tramadol', 'Oksijen Tüpü');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Yoğun Bakım','Pentotal, Norcuron, Oksikodon', 'Entübe');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Yoğun Bakım', 'İzofluran, Norcuron', 'Entübe');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Servis', 'Hidrokortizon, Tramadol', 'Oksijen Tüpü');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Servis', 'Deksametazon, Petidin', 'Serum');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Servis', 'Deksametazon, Teofilin','');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Servis', 'Remdesivir', 'Serum');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Ayakta', 'Favipir, vitamin, demir','');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Ayakta', 'Favipir, vitamin','');
INSERT INTO tedavi (tip, ilac, ek) VALUES ('Ayakta', 'Favipir, vitamin','');
--tahlil
INSERT INTO tahlil (spirometre, dif_test) VALUES (85, 110);
INSERT INTO tahlil (spirometre, dif_test) VALUES (5, 25);
INSERT INTO tahlil (spirometre, dif_test) VALUES (65, 72);
INSERT INTO tahlil (spirometre, dif_test) VALUES (null, 130);
INSERT INTO tahlil (spirometre, dif_test) VALUES (75, 90);
INSERT INTO tahlil (spirometre, dif_test) VALUES (3, 15);
INSERT INTO tahlil (spirometre, dif_test) VALUES (40, 45);
INSERT INTO tahlil (spirometre, dif_test) VALUES (70, 91);
INSERT INTO tahlil (spirometre, dif_test) VALUES (50, 63);
INSERT INTO tahlil (spirometre, dif_test) VALUES (null, 125);
INSERT INTO tahlil (spirometre, dif_test) VALUES (72, 85);
INSERT INTO tahlil (spirometre, dif_test) VALUES (4, 75);
INSERT INTO tahlil (spirometre, dif_test) VALUES (54, 70);
INSERT INTO tahlil (spirometre, dif_test) VALUES (43, 69);
INSERT INTO tahlil (spirometre, dif_test) VALUES (33, 29);
INSERT INTO tahlil (spirometre, dif_test) VALUES (25, 69);

--hasta
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Ali', 'Güven', '1987-09-12', 'E', 1, 1, 1);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Gülcan', 'Özdemir', '1998-05-11','K', 7, 1, 2);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Sami', 'Demirci','2007-06-30','E', 2, 1, 3);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Ayşe', 'Yıldız', '1957-09-07', 'K', 5,4, 4);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Sinem', 'Gündoğan', '1976-04-17', 'K', 6, 5, 5);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Arda', 'İbrahimoğlu', '1999-08-13', 'E', 4, 7, 6);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Sinan', 'Aslan', '1963-08-25', 'E', 7, 1, 7);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Feride', 'Kaya', '1988-03-21', 'K',  8, 2, 8);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Hacer', 'Yıldırım', '1982-11-19', 'K', 9, 3, 9);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Duygu', 'Yılmaz', '1949-10-03', 'K', 10, 4, 10);
INSERT INTO hasta VALUES (nextval('hasta_seq'),'Halime', 'Duvarbaşı', '1965-08-12', 'K', 1, 5, 11);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Ahmet', 'Oğuz', '1983-02-07', 'E', 1, 6, 12);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Ege', 'Kaplan', '1995-06-01', 'E', 1, 7, 13);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Hilal', 'Yazıcı', '1992-12-16', 'K', 5, 8, 14);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Asya', 'Yılmaz', '1992-12-16', 'K', 5, 8, 15);
INSERT INTO hasta VALUES (nextval('hasta_seq'), 'Derin', 'Güçlü' , '1992-12-16', 'K', 3, 2, 16);

--hasta silindiğinde hastayı eski hasta tablosuna kaydeden trigger

CREATE OR REPLACE FUNCTION eski_hastayi_kaydet()
RETURNS TRIGGER AS $$
BEGIN
INSERT INTO eski_hasta VALUES (OLD.hasta_id, current_timestamp, OLD.ad, OLD.soyad, (SELECT d.ad FROM doktor d WHERE OLD.h_dktr=d.doktor_id),(SELECT d.soyad FROM doktor d WHERE OLD.h_dktr=d.doktor_id));
RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER eski_hasta_log
AFTER DELETE
ON hasta
FOR EACH ROW EXECUTE PROCEDURE eski_hastayi_kaydet();




--hastanın kaydını silince hastanın tahlilini de silen trigger

CREATE OR REPLACE FUNCTION tahlili_sil()
RETURNS TRIGGER AS $$
BEGIN
DELETE FROM tahlil WHERE tahlil.tahlil_id=OLD.h_thl;
RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER thl_sil
AFTER DELETE
ON hasta
FOR EACH ROW EXECUTE PROCEDURE tahlili_sil();

--doktor silinince doktora kayıtlı hastaları en az hasta bakan doktora atayan cursorlu fonksiyon ve trigger

CREATE OR REPLACE FUNCTION hasta_guncelleme()
RETURNS TRIGGER AS $$
DECLARE
hastalar CURSOR FOR SELECT hasta_id FROM hasta WHERE h_dktr IS NULL;
min_doktor NUMERIC;
BEGIN
min_doktor := (SELECT d.doktor_id
FROM doktor d
LEFT JOIN hasta h ON d.doktor_id = h.h_dktr 
GROUP BY doktor_id order by COUNT(h.h_dktr) limit 1);
FOR satir IN hastalar LOOP
	UPDATE hasta SET h_dktr=min_doktor WHERE hasta_id=satir.hasta_id;
END LOOP;
RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER doktor_guncelleme
AFTER DELETE
ON doktor
FOR EACH ROW EXECUTE PROCEDURE hasta_guncelleme();


--tedavi ile bilgileri alıp tedavi id döndüren fonksiyon

CREATE or replace FUNCTION tedavi_protokol (yer tedavi.tip%type, medi tedavi.ilac%type, eks tedavi.ek%type)
RETURNS NUMERIC AS $$
DECLARE
tid NUMERIC;
BEGIN
tid:=(SELECT tedavi_id FROM tedavi WHERE tip=yer AND ilac=medi AND ek=eks);

IF tid is null THEN
	INSERT INTO tedavi (tip, ilac, ek) VALUES (yer,medi,eks) RETURNING tedavi_id INTO tid;
END IF;
RETURN tid;
END;
$$ LANGUAGE 'plpgsql';


--sırasıyla yoğun bakım, servis ve ayakta hasta sayısını döndüren recordlu sql fonksiyonu

CREATE TYPE hasta_tipleri AS (tip1 INTEGER, tip2 INTEGER, tip3 INTEGER);

CREATE OR REPLACE FUNCTION hastaBilgileriniGetir()
RETURNS hasta_tipleri AS $$
DECLARE 
	liste hasta_tipleri;
BEGIN
	liste.tip1:=(SELECT count(*) FROM tedavi WHERE tip='Yoğun Bakım');
	liste.tip2:=(SELECT count(*) FROM tedavi WHERE tip='Servis');
	liste.tip3:=(SELECT count(*) FROM tedavi WHERE tip='Ayakta');
	RETURN liste;
END;
$$ LANGUAGE 'plpgsql';

--bu sayfanın hasta tablosu (view)

CREATE VIEW hastatablosu AS
SELECT h.hasta_id, h.ad, h.soyad, 
h.dtarih, h.cinsiyet, h.h_dktr as doktor_id,
d.ad as doktor_ad, d.soyad as doktor_soyad, 
tah.spirometre, tah.dif_test,
ted.tip, ted.ilac, ted.ek
FROM hasta h
INNER JOIN doktor d ON d.doktor_id = h.h_dktr
LEFT JOIN tahlil tah ON tah.tahlil_id = h.h_thl
LEFT JOIN tedavi ted ON ted.tedavi_id = h.h_tdv; 

--doktor tablosu

CREATE VIEW doktortablo AS
SELECT d.doktor_id, d.ad, d.soyad, uzm.alan, hast.hastane_adi, COUNT(h.h_dktr) as hasta_sayisi
FROM doktor d
INNER JOIN uzmanlik uzm on d.doktor_uzm = uzm.uzmanlik_id
INNER JOIN hastane hast on d.doktor_hast = hast.hastane_id
LEFT JOIN hasta h ON d.doktor_id = h.h_dktr 
GROUP BY doktor_id, alan, hastane_adi
ORDER BY doktor_id;

--eski hasta boş kalmasın diye
DELETE FROM hasta WHERE hasta_id = 1;
DELETE FROM hasta WHERE hasta_id = 6;
DELETE FROM hasta WHERE hasta_id = 8;

