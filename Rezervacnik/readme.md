REZERVAČNÍK
Aneta Bukovjanová, Martin Havlík, Václav Pleskač

Zadání: Rezervace míst v restauraci (2-3 řešitelé)
Aplikace na podporu rezervací míst v restauraci. Aplikace eviduje stoly s počtem míst, umístění nekuřácký/kuřácký. Zákazníci si objednávají rezervaci na den a hodinu.

Seznam úkolů:

Třídy:

Aneta Bukovjanová – třída Rezervace
Martin Havlík – třída Restaurace
Václav Pleskač – třída Stůl

Návrhy: 

Aneta Bukovjanová – okna týkající se rezervace (správa rezervace, nová rezervace)
Martin Havlík – realizování ukládaní souborů (čtení souborů), spuštění GUI, úvodní menu
Václav Pleskač – okna týkající se stolů (správa stolů, nový stůl)


Use case slovní popis včetně scénářů

Spustit aplikaci	

UseCase	Spustit aplikaci
Summary	Uživatel spustí aplikaci
Actor	Uzivatel
	
Precondition	
					Uživatel má přístup k aplikaci a má funkční rozhraní.
Postcondition	
					Aplikace se správně spustila a otevřelo se okno úvodního menu.
Base Sequence	
					1.	Uživatel spustí aplikaci
					2.	Uživateli se zobrazí GUI aplikace
Branch Sequence	
Exception Sequence	
					1.	Uživatel spustí aplikaci
					2.	Aplikace se spustí s chybou
					3.	Uživatel restartuje aplikaci
					4.	Uživateli se zobrazí GUI aplikace
Sub UseCase	
Note	

 
Ukončit aplikaci

UseCase	Ukončit aplikaci
Summary	Uživatel ukončuje aplikaci
Actor	Uzivatel
Precondition	
					Aplikace je spuštěna.
Postcondition	
					Aplikace se správně ukončila a rezervace je uložena.
Base Sequence	
					1.	Uživatel dá příkaz k ukončení aplikace
					2.	Systém uloží rezervace. Viz UC Uložit záznam3. Aplikace se ukončí
Branch Sequence	
Exception Sequence	
					1.	Uživatel dá příkaz k ukončení aplikace
					2.	Dojde k chybě při ukládání rezervace.  Viz UC Uložit záznam
					3.	Uživatel chybu opraví
					4.	Systém uloží rezervace
					5.	Aplikace se ukončí
Sub UseCase	Uložit záznam
Note	

 
Uložit záznam	

UseCase	Uložit záznam
Summary	Uživatel uloží záznam
Actor	Uzivatel
Precondition	
					Aplikace je spuštěna a je co uložit
Postcondition	
					Záznam je uložen v databázi
Base Sequence	
					1.	Uživatel klikne na tlačítko "uložit"
					2.	Systém uloží záznam
					3.	Záznam je uložen v databázi
Branch Sequence	
Exception Sequence	
					1.	Uživatel klikne na tlačítko "uložit"
					2.	Uložení skončí chybou
					3.	Uživatel zkontroluje data a klikne na tlačítko znovu
					4.	Záznam je uložen v databázi
Sub UseCase	
Note	

 
Udržovat údaje o stolu	

UseCase	Udržovat údaje o stolu
Summary	Uživatel udržuje údaje o stolu (mění počet míst, mění stůl na kuřácký a naopa k, ruší, prohlíží).
Actor	Uzivatel
Precondition	
					Stůl je k dispozici.
					Stůl je buď kuřácký, nebo nekuřácký.
Postcondition	
					Všechny údaje jsou správně vyplněny Stůl je k dispozici.
Base Sequence	
					1.	Uživatel si vybere danou operaci se stolem
					2.	Systém připraví dané okno pro manipulace se stolem
					3.	Uživatel vybere stůl, který chce udržovat
					4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl	
					5.	Uživatel vloží nová data o rezervaci
					6.	Systém ověří správnost údajů
					7.	Systém upraví pramatery stolu v seznamu stolů
Branch Sequence	
Exception Sequence	
					1.	Uživatel si vybere danou operaci se stolem
					2.	Systém připraví dané okno pro manipulace se stolem
					3.	Uživatel vybere stůl, který chce udržovat
					4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl
					5.	Uživatel vloží nová data o rezervaci
					6.	Systém ověří správnost údajů
					7.	Systém upozorní na chybu v rezervaci
					8.	Uživatel chybu opraví
					9.	Systém upraví pramatery stolu v seznamu stolů
Sub UseCase	Nalézt stůl
Note	

 
Nalézt stůl	

UseCase	Nalézt stůl
Summary	Systém udržuje údaje o stolech a nalezne stůl na kterém je daná rezervace
Actor	Uzivatel
Precondition	
					V restauraci se nacházejí evidované stoly
					V systému je záznam o těchto stolech
Postcondition	
					Záznam o stolech je aktuální
Base Sequence	
					1.	Uživatel chce nalézt záznam o daném stolu
					2.	Systém nalezne záznam o daném stolu
					3.	Systém předá záznam uživateli
Branch Sequence	
Exception Sequence	
					1.	Uživatel chce nalézt záznam o daném stolu
					2.	Systém nenalezne záznam o daném stolu
					3.	Systém upozorní uživatele na chybu
					4.	Uživatel chybu upraví
					5.	Systém předá záznam uživateli
Sub UseCase	
Note	

Udržovat údaje o rezervaci	

UseCase	Udržovat údaje o rezervaci
Summary	Uživatel udržuje údaje (zakládá, mění, ruší, prohlíží) o rezervaci
Actor	Uzivatel
Precondition	
					Stůl, kde je vystavena rezervace existuje.
					Datum na které je rezervace vystavena existuje.
					Restaurace je otevřená v hodinu, která je uvedena v rezervaci
Postcondition	
					Všechny údaje rezervace jsou správně vyplněny
					Rezervace je k dispozici
Base Sequence	
					1.	Uživatel si vybere danou operaci s rezervací
					2.	Systém připraví dané okno pro manipulace s rezervací
					3.	Uživatel vybere rezervaci, kterou chce udržovat
					4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl
					5.	Uživatel vloží nová data o rezervaci
					6.	Systém ověří správnost údajů
					7.	Systém upraví rezervaci a záznam o jejím výskytu
Branch Sequence	
Exception Sequence	
					1.	Uživatel si vybere danou operaci s rezervací
					2.	Systém připraví dané okno pro manipulace s rezervací
					3.	Uživatel vybere rezervaci, kterou chce udržovat
					4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl
					5.	Uživatel vloží nové data o rezervaci
					6.	Systém ověří správnost údajů
					7.	Systém upozorní na chybu v rezervaci
					8.	Uživatel chybu opraví
					9.	Systém upraví rezervaci a záznam o jejím výskytu
Sub UseCase	Nalézt stůl
Note	

 
Struktura souborů nebo struktura databáze: 
podoba CSV dokumentu
stul;pocet mist;kuracky;den;měsíc;rok;hodina;jmeno;

Konvence
getter - vždy get(název atributu)
setter - vždy set(název atributu)
boolean getter	- is(název atributu)
pokud je atribut boolean - napsat jako sloveso

