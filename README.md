# Szyfrowanie tekstu - zadanie 4

Projekt to aplikacja napisana w języku Java, służąca do szyfrowania i odszyfrowywania plików tekstowych za pomocą, między innymi, szyfru Cezara. Program odczytuje tekst ze wskazanego pliku źródłowego, przetwarza go i zapisuje wynik do pliku docelowego. 

## Główne założenia projektowe
- **Interfejs CLI(command line interface)**: Aplikacja przyjmuje wszystkie instrukcje od użytkownika wyłącznie poprzez argumenty wiersza poleceń.
- **Wzorzec Strategii**: Algorytmy szyfrujące implementują wspólny interfejs `CipherStrategy`. Umożliwia to łatwą rozbudowę w przyszłości (np. o szyfr Morse'a) bez modyfikacji głównej logiki programu.
- **Buforowanie (Chunking)**: Wejście i wyjście obsługiwane jest poprzez odczytywanie pliku w paczkach (chunks) o ustalonym rozmiarze. Zapobiega to problemom z pamięcią przy przetwarzaniu bardzo dużych plików tekstowych.

## Uruchamianie i składnia argumentów

Aby uruchomić program, należy przekazać parzystą liczbę argumentów w postaci par: `-flaga wartość`. Kolejność podawania flag nie ma znaczenia.

**Składnia:**
`java Main -source <ścieżka_we> -destination <ścieżka_wy> -mode <tryb> -type <typ_szyfru> -shift <wartość>`

**Dostępne argumenty:**
* `-source` : Ścieżka do pliku wejściowego (np. `wejscie.txt`).
* `-destination` : Ścieżka do pliku wyjściowego (np. `wyjscie.txt`).
* `-mode` : Tryb działania programu. Dopuszczalne wartości to `CIPHER` (szyfrowanie) lub `DECIPHER` (odszyfrowywanie).
* `-type` : Wybór algorytmu. Dopuszczalne wartości to `CAESAR` (obecnie obsługiwany) lub `MORSE`.
* `-shift` : Klucz (przesunięcie) dla szyfru Cezara. Przyjmuje liczby całkowite (dodatnie lub ujemne).

## Przykłady użycia

Szyfrowanie pliku z przesunięciem o 3 pozycje:
```bash
java Main.java -source plain.txt -destination encrypted.txt -mode CIPHER -type CAESAR -shift 3
```
Odszyfrowywanie wygenerowanego pliku:
```bash
java Main.java -source encrypted.txt -destination decrypted.txt -mode DECIPHER -type CAESAR -shift 3
```
