REZERVAČNÍK
Aneta Bukovjanová, Martin Havlík, Václav Pleskač<br />

Zadání: Rezervace míst v restauraci (2-3 řešitelé)<br />
Aplikace na podporu rezervací míst v restauraci. Aplikace eviduje stoly s počtem míst, umístění nekuřácký/kuřácký. Zákazníci si objednávají rezervaci na den a hodinu.<br />

Doplnění zadání<br />
Obsluha restaurace zadává údaje, které získá od zákazníka, např. skrz telefonické objednání.<br />

Seznam úkolů:<br />

Třídy:<br />

Aneta Bukovjanová – třída Rezervace<br />
Martin Havlík – třída Restaurace<br />
Václav Pleskač – třída Stůl<br />

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/class.png)

Návrhy:<br />

Aneta Bukovjanová – okna týkající se rezervace (správa rezervace, nová rezervace)<br />
Martin Havlík – realizování ukládaní souborů (čtení souborů), spuštění GUI, úvodní menu<br />
Václav Pleskač – okna týkající se stolů (správa stolů, nový stůl)<br />

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/use.png)

Use case slovní popis včetně scénářů<br />

Spustit aplikaci<br />

UseCase	Spustit aplikaci<br />
Summary	Uživatel spustí aplikaci<br />
Actor	Uzivatel<br />  
	
Precondition<br />
Uživatel má přístup k aplikaci a má funkční rozhraní.<br />
Postcondition<br />
Aplikace se správně spustila a otevřelo se okno úvodního menu.<br />
Base Sequence<br />
1.	Uživatel spustí aplikaci<br />
2.	Uživateli se zobrazí GUI aplikace<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel spustí aplikaci<br />  
2.	Aplikace se spustí s chybou<br /> 
3.	Uživatel restartuje aplikaci<br /> 
4.	Uživateli se zobrazí GUI aplikace<br /> 
Sub UseCase<br /> 	
Note<br /> 

Ukončit aplikaci<br />

UseCase	Ukončit aplikaci<br />
Summary	Uživatel ukončuje aplikaci<br />
Actor	Uzivatel<br />
Precondition<br />
Aplikace je spuštěna.<br />
Postcondition<br />
Aplikace se správně ukončila a rezervace je uložena.<br />
Base Sequence<br />	
1.	Uživatel dá příkaz k ukončení aplikace<br />
2.	Systém uloží rezervace. Viz UC Uložit záznam3. Aplikace se ukončí<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel dá příkaz k ukončení aplikace<br />
2.	Dojde k chybě při ukládání rezervace.  Viz UC Uložit záznam<br />
3.	Uživatel chybu opraví<br />
4.	Systém uloží rezervace<br />
5.	Aplikace se ukončí<br />
Sub UseCase	Uložit záznam<br />
Note<br />

Uložit záznam<br />

UseCase	Uložit záznam<br />
Summary	Uživatel uloží záznam<br />
Actor	Uzivatel<br />
Precondition<br />
Aplikace je spuštěna a je co uložit<br />
Postcondition<br />
Záznam je uložen v databázi<br />
Base Sequence<br />
1.	Uživatel klikne na tlačítko "uložit"<br />
2.	Systém uloží záznam<br />
3.	Záznam je uložen v databázi<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel klikne na tlačítko "uložit"<br />
2.	Uložení skončí chybou<br />
3.	Uživatel zkontroluje data a klikne na tlačítko znovu<br />
4.	Záznam je uložen v databázi<br />
Sub UseCase<br />	
Note<br />

Udržovat údaje o stolu<br />

UseCase	Udržovat údaje o stolu<br />
Summary	Uživatel udržuje údaje o stolu (mění počet míst, mění stůl na kuřácký a naopa k, ruší, prohlíží).<br />
Actor	Uzivatel<br />
Precondition<br />	
Stůl je k dispozici.<br />
Stůl je buď kuřácký, nebo nekuřácký.<br />
Postcondition<br />
Všechny údaje jsou správně vyplněny Stůl je k dispozici.<br />
Base Sequence<br />
1.	Uživatel si vybere danou operaci se stolem<br />
2.	Systém připraví dané okno pro manipulace se stolem<br />
3.	Uživatel vybere stůl, který chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nová data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upraví pramatery stolu v seznamu stolů<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel si vybere danou operaci se stolem<br />
2.	Systém připraví dané okno pro manipulace se stolem<br />
3.	Uživatel vybere stůl, který chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nová data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upozorní na chybu v rezervaci<br />
8.	Uživatel chybu opraví<br />
9.	Systém upraví pramatery stolu v seznamu stolů<br />
Sub UseCase	Nalézt stůl<br />
Note<br />

Nalézt stůl<br />

UseCase	Nalézt stůl<br />
Summary	Systém udržuje údaje o stolech a nalezne stůl na kterém je daná rezervace<br />
Actor	Uzivatel<br />
Precondition<br />
V restauraci se nacházejí evidované stoly<br />
V systému je záznam o těchto stolech<br />
Postcondition<br />
Záznam o stolech je aktuální<br />
Base Sequence<br />
1.	Uživatel chce nalézt záznam o daném stolu<br />
2.	Systém nalezne záznam o daném stolu<br />
3.	Systém předá záznam uživateli<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel chce nalézt záznam o daném stolu<br />
2.	Systém nenalezne záznam o daném stolu<br />
3.	Systém upozorní uživatele na chybu<br />
4.	Uživatel chybu upraví<br />
5.	Systém předá záznam uživateli<br />
Sub UseCase<br />
Note<br />

Udržovat údaje o rezervaci<br />

UseCase	Udržovat údaje o rezervaci<br />
Summary	Uživatel udržuje údaje (zakládá, mění, ruší, prohlíží) o rezervaci<br />
Actor	Uzivatel<br />
Precondition<br />
Stůl, kde je vystavena rezervace existuje.<br />
Datum na které je rezervace vystavena existuje.<br />
Restaurace je otevřená v hodinu, která je uvedena v rezervaci<br />
Postcondition<br />	
Všechny údaje rezervace jsou správně vyplněny<br />
Rezervace je k dispozici<br />
Base Sequence<br />
1.	Uživatel si vybere danou operaci s rezervací<br />
2.	Systém připraví dané okno pro manipulace s rezervací<br />
3.	Uživatel vybere rezervaci, kterou chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nová data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upraví rezervaci a záznam o jejím výskytu<br />
Branch Sequence<br />
Exception Sequence<br />
1.	Uživatel si vybere danou operaci s rezervací<br />
2.	Systém připraví dané okno pro manipulace s rezervací<br />
3.	Uživatel vybere rezervaci, kterou chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nové data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upozorní na chybu v rezervaci<br />
8.	Uživatel chybu opraví<br />
9.	Systém upraví rezervaci a záznam o jejím výskytu<br />
Sub UseCase	Nalézt stůl<br />
Note<br />
 
Struktura souborů nebo struktura databáze:<br />
podoba CSV dokumentu<br />
stul;pocet mist;kuracky;den;měsíc;rok;hodina;jmeno;<br />

Návrh oken<br />

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/novaRezervace.png)

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/novyStul.png)

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/spravaRezervace.png)

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/spravaStolu.png)

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/uvod.png)

Konvence<br />
getter - vždy get(název atributu)<br />
setter - vždy set(název atributu)<br />
boolean getter	- is(název atributu)<br />
pokud je atribut boolean - napsat jako sloveso<br />

