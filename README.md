# JAVA2_DU_LEKCE_03

1. Napište program, který vezme pole Stringu A, b, C, De, fF, gHiJK, LmN 1.1. Najde nejdelším retězec 1.2. V nejdelším řetězci spočítá počet kapitálek
2. Napište program, který přečte soubor (priklad2.txt) a spočítá počet znaků na každém řádku, který neobsahuje číslici.
3. Napište program, který přečte dva soubory (priklad3_1.txt, priklad3_2.txt), vezme všechna čísla a spočítá jejich průměr zaokrouhlený na 2 desetinná místa.
4. Napište program, který vezme 2 čísla (a,b) a spočítá druhou mocninu všech čísel mezi a a b včetně <a,b>.

Problémy:

@1  nevím, co je špatně, ale píše mi to vždycky o jednu víc, než by mělo
-- výsledek hledání je Optional ->  potreba nahradit .toString()  za .get()

@3  kvůli desetinné čárce v lokálním nastavení jsem musela změnit desetinnou tečku u des.čísel v původním souboru na čárku
    zaokrouhlení na 2 desetinná místa je krkolomné
-- zapsat System.out.printf("%.2f", výsledek bez použití Math.round);
