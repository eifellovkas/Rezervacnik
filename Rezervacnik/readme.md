REZERVAČNÍK
Aneta Bukovjanová, Martin Havlík, Václav Pleskač<br />

Zadání: Rezervace míst v restauraci (2-3 řešitelé)<br />
Aplikace na podporu rezervací míst v restauraci. Aplikace eviduje stoly s počtem míst, umístění nekuřácký/kuřácký. Zákazníci si objednávají rezervaci na den a hodinu.<br />

Doplnění zadání<br />
Obsluha restaurace zadává údaje, které získá od zákazníka, např. skrz telefonické objednání. Obsluha bude moci spravovat stoly a objednávky a bude mít možnost vidět, které objednávky se v daný čas uskuteční<br />

Seznam úkolů:<br />

Třídy:<br />

Aneta Bukovjanová – třída Stůl<br />
Martin Havlík – třída Restaurace<br />
Václav Pleskač – třída Rezervace<br />

Třída zákazník se nebude implementovat. Podle doporučení by měla zahrnovat možnost zjištovat, v jaké časy zákazník rád chodí do restaurace.<br />

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/class.png)

Návrhy:<br />

Aneta Bukovjanová – okna týkající se stolů (správa stolů, nový stůl)<br />
Martin Havlík – realizování ukládaní souborů (čtení souborů), spuštění GUI, úvodní menu<br />
Václav Pleskač – okna týkající se rezervace (správa rezervace, nová rezervace)<br />

![alt text](https://github.com/eifellovkas/Rezervacnik/blob/master/Rezervacnik/src/main/resources/ui/use.png)

Use case slovní popis včetně scénářů<br />
<br />

Spustit aplikaci<br />

UseCase	Spustit aplikaci<br />
Summary	Uživatel spustí aplikaci<br />
Actor	Uzivatel<br />  
Precondition<br />
1.	Uživatel má přístup k aplikaci a má funkční rozhraní.<br />
<br />
Postcondition<br />
1.	Aplikace se správně spustila a otevřelo se okno úvodního menu.<br />
<br />
Base Sequence<br />
1.	Uživatel spustí aplikaci<br />
2.	Uživateli se zobrazí GUI aplikace<br />
<br />
Exception Sequence<br />
1.	Uživatel spustí aplikaci<br />  
2.	Aplikace se spustí s chybou<br /> 
3.	Uživatel restartuje aplikaci<br /> 
4.	Uživateli se zobrazí GUI aplikace<br /> 
<br />

Ukončit aplikaci<br />

UseCase	Ukončit aplikaci<br />
Summary	Uživatel ukončuje aplikaci<br />
Actor	Uzivatel<br />
Precondition<br />
1.	Aplikace je spuštěna.<br />
<br />
Postcondition<br />
1.	Aplikace se správně ukončila a rezervace je uložena.<br />
<br />
Base Sequence<br />	
1.	Uživatel dá příkaz k ukončení aplikace<br />
2.	Systém uloží rezervace. Viz UC Uložit záznam3. Aplikace se ukončí<br />
<br />
Exception Sequence<br />
1.	Uživatel dá příkaz k ukončení aplikace<br />
2.	Dojde k chybě při ukládání rezervace.  Viz UC Uložit záznam<br />
3.	Uživatel chybu opraví<br />
4.	Systém uloží rezervace<br />
5.	Aplikace se ukončí<br />
<br />
Sub UseCase	Uložit záznam<br />
<br />

Uložit záznam<br />

UseCase	Uložit záznam<br />
Summary	Uživatel uloží záznam<br />
Actor	Uzivatel<br />
Precondition<br />
1.	Aplikace je spuštěna a je co uložit<br />
<br />
Postcondition<br />
1.	Záznam je uložen v databázi<br />
<br />
Base Sequence<br />
1.	Uživatel klikne na tlačítko "uložit"<br />
2.	Systém uloží záznam<br />
3.	Záznam je uložen v databázi<br />
<br />
Exception Sequence<br />
1.	Uživatel klikne na tlačítko "uložit"<br />
2.	Uložení skončí chybou<br />
3.	Uživatel zkontroluje data a klikne na tlačítko znovu<br />
4.	Záznam je uložen v databázi<br />
<br />
Sub UseCase<br />	
<br />

Udržovat údaje o stolu<br />

UseCase	Udržovat údaje o stolu<br />
Summary	Uživatel udržuje údaje o stolu (mění počet míst, mění stůl na kuřácký a naopa k, ruší, prohlíží).<br />
Actor	Uzivatel<br />
Precondition<br />	
1.	Stůl je k dispozici.<br />
2.	Stůl je buď kuřácký, nebo nekuřácký.<br />
<br />
Postcondition<br />
1.	Všechny údaje jsou správně vyplněny<br />
2.	Stůl je k dispozici.<br />
<br />
Base Sequence<br />
1.	Uživatel si vybere danou operaci se stolem<br />
2.	Systém připraví dané okno pro manipulace se stolem<br />
3.	Uživatel vybere stůl, který chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nová data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upraví pramatery stolu v seznamu stolů<br />
<br />
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
<br />
Sub UseCase	Nalézt stůl<br />
<br />

Nalézt stůl<br />

UseCase	Nalézt stůl<br />
Summary	Systém udržuje údaje o stolech a nalezne stůl na kterém je daná rezervace<br />
Actor	Uzivatel<br />
Precondition<br />
1.	V restauraci se nacházejí evidované stoly<br />
2.	V systému je záznam o těchto stolech<br />
<br />
Postcondition<br />
1.	Záznam o stolech je aktuální<br />
<br />
Base Sequence<br />
1.	Uživatel chce nalézt záznam o daném stolu<br />
2.	Systém nalezne záznam o daném stolu<br />
3.	Systém předá záznam uživateli<br />
<br />
Exception Sequence<br />
1.	Uživatel chce nalézt záznam o daném stolu<br />
2.	Systém nenalezne záznam o daném stolu<br />
3.	Systém upozorní uživatele na chybu<br />
4.	Uživatel chybu upraví<br />
5.	Systém předá záznam uživateli<br />
<br />
Sub UseCase<br />
<br />

Udržovat údaje o rezervaci<br />

UseCase	Udržovat údaje o rezervaci<br />
Summary	Uživatel udržuje údaje (zakládá, mění, ruší, prohlíží) o rezervaci<br />
Actor	Uzivatel<br />
Precondition<br />
1.	Stůl, kde je vystavena rezervace existuje.<br />
2.	Datum na které je rezervace vystavena existuje.<br />
3.	Restaurace je otevřená v hodinu, která je uvedena v rezervaci<br />
<br />
Postcondition<br />	
1.	Všechny údaje rezervace jsou správně vyplněny<br />
2.	Rezervace je k dispozici<br />
<br />
Base Sequence<br />
1.	Uživatel si vybere danou operaci s rezervací<br />
2.	Systém připraví dané okno pro manipulace s rezervací<br />
3.	Uživatel vybere rezervaci, kterou chce udržovat<br />
4.	Systém zjistí na jakém stole se rezervace nachází viz. UC Nalézt stůl<br />
5.	Uživatel vloží nová data o rezervaci<br />
6.	Systém ověří správnost údajů<br />
7.	Systém upraví rezervaci a záznam o jejím výskytu<br />
<br />
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
<br />
Sub UseCase	Nalézt stůl<br />
<br />
 
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

