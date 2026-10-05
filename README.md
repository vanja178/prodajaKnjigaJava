# Prodaja Knjiga

# Demo 
https://github.com/user-attachments/assets/4df445ba-8d25-4d13-8e08-8fa32b62efd1

## Opis aplikacije
Prodaja Knjiga je desktop aplikacija u **Javi** za praćenje prodaje knjiga, realizovana po **klijent-server arhitekturi**. Omogućava radniku da evidentira prodaju knjiga kroz račune, vodi evidenciju o kupcima i njihovim kategorijama, o knjigama, o radnicima i smenama u kojima rade, kao i da pretražuje i menja već unete podatke.

Aplikacija se sastoji iz **klijentskog programa** (korisnički interfejs, Swing forme) i **serverskog programa** (aplikaciona logika i veza sa bazom), koji komuniciraju preko **soketa** razmenom objekata klasa `Zahtev` i `Odgovor`. Pri prijavi se obezbeđuje **autentifikacija** radnika (korisničko ime i šifra). Svaka sistemska operacija se izvršava u okviru **jedne transakcije** (commit / rollback), čime se čuva konzistentnost podataka, naročito pri radu sa računom i njegovim stavkama.

Projekat je izrađen po fazama **pojednostavljene Larmanove metode** u okviru seminarskog rada iz predmeta **Projektovanje softvera** (Fakultet organizacionih nauka, Univerzitet u Beogradu).

---
## Ključne funkcionalnosti
| Koncept | Funkcionalnosti |
|---|---|
| Račun | Ubaci, Pretraži, Promeni |
| Kupac | Ubaci, Pretraži, Promeni, Obriši |
| Radnik | Prijavi, Ubaci, Pretraži, Promeni, Obriši |
| Knjiga | Ubaci, Pretraži, Promeni, Obriši |
| Kategorija | Ubaci, Pretraži, Promeni, Obriši |
| Smena | Ubaci, Pretraži, Promeni, Obriši |

- Preko jednog računa može se prodati više knjiga (stavke računa); ukupan iznos se automatski izračunava.
- Kupac pripada jednoj kategoriji, a kategorija određuje popust (kategorija „VIP“ ima popust 20 %).
- Radnik može biti vezan za više smena, a smena za više radnika (`RadnikSmena`).
- Pretraga po kriterijumima (račun, radnik, kupac, knjiga, kategorija, smena).
- Pregledne poruke korisniku za uspešne operacije i greške.

---
## Tehnologije
| Kategorija | Tehnologije |
|---|---|
| Programski jezik | Java |
| Korisnički interfejs | Java Swing (NetBeans GUI forme) |
| Komunikacija | Java soketi (`Zahtev` / `Odgovor`) |
| Baza podataka | MySQL |
| Razvojno okruženje | NetBeans |
| Arhitektura | Troslojna: korisnički interfejs → aplikaciona logika → skladište podataka |

---
## Arhitektura
| Sloj | Opis |
|---|---|
| Korisnički interfejs (klijent) | Ekranske forme i kontroleri korisničkog interfejsa (npr. `RacunGuiController`, `KupacGuiController`). |
| Aplikaciona logika (server) | Kontroler aplikacione logike (`Kontroler`, singleton) i sistemske operacije (klase `SO...` koje nasleđuju `SistemskaOperacija`). |
| Skladište podataka | MySQL baza; pristup preko `BrokerBaze`. |

Svaka sistemska operacija prati šablon: otvaranje konekcije → provera ograničenja → izvršenje → `commit` ili `rollback` → zatvaranje konekcije. Domenske klase implementiraju interfejs `ApstraktniDomenskiObjekat`.

---
## Struktura projekta
Rešenje je organizovano kroz tri NetBeans projekta:

```
├── Server/                  # Serverska aplikacija
│   ├── forms/               # Forma za pokretanje i podešavanje servera
│   ├── controller/          # Kontroler aplikacione logike
│   ├── operation/           # Sistemske operacije (SOUbaciRacun, SOPromeniKupac, ...)
│   ├── database/            # Broker baze (BrokerBaze)
│   └── configuration/       # Čitanje konfiguracije konekcije i porta
├── Kupac/ (Klijent)         # Klijentska aplikacija
│   ├── forms/               # Ekranske forme (račun, kupac, radnik, knjiga, ...)
│   ├── controller/          # Kontroleri korisničkog interfejsa
│   └── tablemodel/          # Modeli tabela za prikaz listi
└── Zajednicki/              # Zajedničke klase za klijent i server
    ├── model/               # Domenske klase
    └── communication/       # Zahtev, Odgovor, Operacija, Posiljalac, Primalac
```

---
## Model podataka
Relacioni model:

| Tabela | Atributi |
|---|---|
| `radnik` | idRadnik, ime, prezime, korisnickoIme, sifra |
| `knjiga` | idKnjiga, naziv, cena |
| `kategorija` | idKategorija, naziv, popust |
| `smena` | idSmena, naziv |
| `kupac` | idKupac, ime, prezime, email, brojTelefona, *idKategorija* |
| `racun` | idRacun, ukupanIznos, popust, datum, *idRadnik*, *idKupac* |
| `stavkaracuna` | *idRacun*, rb, iznos, cena, kolicina, *idKnjiga* |
| `radnikSmena` | *idRadnik*, *idSmena*, datum |

Ključna ograničenja: popust je u opsegu 0–100, količina stavke mora biti veća od nule, a iznos stavke se računa kao `cena * kolicina * (1 - popust/100)`. Brisanje kupca koji ima izdate račune nije dozvoljeno.

---
## Preduslovi
- Java JDK
- NetBeans IDE
- MySQL server (npr. XAMPP)
- Git

---
## Lokalno pokretanje
### 1. Kloniranje repozitorijuma
```bash
git clone https://github.com/vanja178/prodajaKnjigaJava.git
cd prodajaKnjigaJava
```

### 2. Baza podataka
Pokrenite MySQL server i kreirajte bazu:
```sql
CREATE DATABASE prodajaKnjiga;
```
Zatim kreirajte tabele iz sekcije „Model podataka“ (`radnik`, `knjiga`, `kategorija`, `smena`, `kupac`, `racun`, `stavkaracuna`, `radnikSmena`) i unesite bar jednog radnika za prijavu.

### 3. Otvaranje projekata u NetBeans-u
U NetBeans-u otvorite sva tri projekta (`Zajednicki`, `Server`, `Kupac`). Projekti `Server` i `Kupac` zavise od projekta `Zajednicki`, pa on mora biti dodat kao biblioteka. Dodajte i MySQL JDBC drajver (MySQL Connector/J).

### 4. Pokretanje servera
Pokrenite projekat `Server` i u serverskoj formi podesite parametre:
- meni **Podešavanja** → konfiguracija baze (URL, korisničko ime i lozinka za bazu `prodajaKnjiga`),
- meni **Podešavanja** → konfiguracija porta,

pa kliknite na dugme za pokretanje servera.

### 5. Pokretanje klijenta
Pokrenite projekat `Kupac` (klijent). Prijavite se korisničkim imenom i šifrom radnika, nakon čega se otvara glavna forma sa menijem.

> Redosled pokretanja: MySQL → Server → Klijent.

---
## Meni aplikacije
1. Dokumenti → Račun
2. Pružalac usluge → Radnik
3. Primalac usluge → Kupac
4. Šifarnici → Kategorija, Knjiga, Smena
5. Podešavanja sistema
6. O programu

---
## Testiranje
Testirani su svi implementirani slučajevi korišćenja, uključujući i neispravne unose: popust van opsega 0–100, račun bez stavki, količina manja ili jednaka nuli, brisanje kupca koji ima izdate račune i prijava sa pogrešnom šifrom. U svim slučajevima sistem odbija operaciju, prikazuje poruku o grešci i poništava transakciju (`rollback`).

---
## Autor
| Ime i prezime | Broj indeksa | Mentor |
|---|---|---|
| Vanja Antin | 2022/0335 | Prof. dr Siniša Vlajić |
