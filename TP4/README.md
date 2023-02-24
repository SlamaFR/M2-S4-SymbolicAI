# Symbolic AI • TP 4

## Exercice 1

On utilise $p$ pour désigner “Il a acheté un billet de loto” et $q$ pour “Il a gagné le jackpot”. Exprimer les formules suivantes en français.

1. $\neg p$ donne “Il n'a pas acheté un billet de loto”.
2. $p \vee q$ donne “Il a acheté un billet de loto ou il a gagné le jackpot”.
3. $p \wedge q$ donne “Il a acheté un billet de loto et il a gagné le jackpot”.
4. $p \Rightarrow q$ donne “Il a acheté un billet de loto implique qu'il ait gagné le jackpot”.
5. $\neg p \Rightarrow \neg q$ donne “Il n'a pas acheté un billet de loto implique qu'il n'ait pas gagné le jackpot”.
6. $\neq p \vee (p \wedge q)$ donne “Il n'a pas acheté un billet de loto, ou il en acheté un et a gagné le jackpot”.

## Exercice 2

On pose $u$ “Le système fonctionne en mode multi-utilisateur”, $s$ “Le système fonctionnement normalement”, $k$ “Le noyau fonctionne normalement” et $h$ “Le système fonctionne en mode interruption”.

Représenter les énoncés suivants en logique propositionnelle et déterminer (avec des tables de vérité) si ils sont satisfaisables ou non.

1. Le système fonctionne en mode multi-utilisateur si et seulement si le système fonctionne normalement.
    |  $u$  |  $s$  | $u \Leftrightarrow s$ |
    | :---: | :---: | :-------------------: |
    |   0   |   0   |           1           |
    |   0   |   1   |           0           |
    |   1   |   0   |           0           |
    |   1   |   1   |           1           |

2. Si le système fonctionne normalement, alors le noyau fonctionne normalement.
    |  $s$  |  $k$  | $s \Rightarrow k$ |
    | :---: | :---: | :---------------: |
    |   0   |   0   |         1         |
    |   0   |   1   |         1         |
    |   1   |   0   |         0         |
    |   1   |   1   |         1         |

3. Soit le noyau fonctionne pas, soit le système fonctionne en mode interruption.
    |  $k$  |  $h$  | $\neg k$ | $\neg k \vee h$ |
    | :---: | :---: | :------: | :-------------: |
    |   0   |   0   |    1     |        1        |
    |   0   |   1   |    1     |        1        |
    |   1   |   0   |    0     |        0        |
    |   1   |   1   |    0     |        1        |

4. Si le système ne fonctionne pas en mode multi-utilisateur, alors le système fonctionne en mode interruption.
    |  $u$  |  $h$  | $\neg u$ | $\neg u \Rightarrow  h$ |
    | :---: | :---: | :------: | :---------------------: |
    |   0   |   0   |    1     |            0            |
    |   0   |   1   |    1     |            1            |
    |   1   |   0   |    0     |            1            |
    |   1   |   1   |    0     |            1            |


5. Le système ne fonctionne pas en mode interruption.
    |  $h$  | $\neg h$ |
    | :---: | :------: |
    |   0   |    1     |
    |   1   |    0     |

## Exercice 3

Pour chaque formule suivante, construire une table de vérité et conclure si elle est valide ou satisfaisable.

1. $p \wedge \neg p$ n'est pas satisfaisable.
    |  $p$  | $p \wedge \neg p$ |
    | :---: | :---------------: |
    |   0   |         0         |
    |   1   |         0         |

2. $p \vee \neg p$ est satisfaisable.
    |  $p$  | $p \vee \neg p$ |
    | :---: | :------------: |
    |   0   |       1        |
    |   1   |       1        |

3. $(p \vee \neg q) \Rightarrow q$ est satisfaisable.
    |  $p$  |  $q$  |  $p \vee \neg q$  | $(p \vee \neg q) \Rightarrow q$ |
    | :---: | :---: | :---: | :----------------------------: |
    |   0   |   0   |   1   |                0               |
    |   0   |   1   |   0   |                1               |
    |   1   |   0   |   1   |                0               |
    |   1   |   1   |   1   |                1               |

4. $(p \vee q) \Rightarrow (p \wedge q)$ n'est pas satisfaisable.
    |  $p$  |  $q$  |  $p \vee q$  |  $p \wedge q$  | $(p \vee q) \Rightarrow (p \wedge q)$ |
    | :---: | :---: | :----------: | :------------: | :-----------------------------------: |
    |   0   |   0   |      0       |       0        |                   0                   |
    |   0   |   1   |      1       |       0        |                   0                   |
    |   1   |   0   |      1       |       0        |                   0                   |
    |   1   |   1   |      1       |       1        |                   1                   |

5. $(p \Rightarrow q) \Leftrightarrow (\neg q \Rightarrow \neg p)$ est satisfaisable.
    |  $p$  |  $q$  | $p \Rightarrow q$ | $\neg q$ | $\neg p$ | $\neg q \Rightarrow \neg p$ | $(p \Rightarrow q) \Leftrightarrow (\neg q \Rightarrow \neg p)$ |
    | :---: | :---: | :--------------: | :------: | :------: | :-----------------------: | :----------------------------------------------------------: |
    |   0   |   0   |        1         |    1     |    1     |            1             |                            1                             |
    |   0   |   1   |        1         |    0     |    1     |            1             |                            1                             |
    |   1   |   0   |        0         |    1     |    0     |            0             |                            0                             |
    |   1   |   1   |        1         |    0     |    0     |            1             |                            1                             |

6. $(p \Rightarrow q) \Rightarrow (q \Rightarrow p)$ est satisfaisable.
    |  $p$  |  $q$  | $p \Rightarrow q$ | $q \Rightarrow p$ | $(p \Rightarrow q) \Rightarrow (q \Rightarrow p)$ |
    | :---: | :---: | :--------------: | :--------------: | :---------------------------------------------: |
    |   0   |   0   |        1         |        1         |                       1                        |
    |   0   |   1   |        1         |        0         |                       0                        |
    |   1   |   0   |        0         |        1         |                       1                       |
    |   1   |   1   |        1         |        1         |                       1                        |

## Exercice 4

**“Le majordome et le cuisinier ne sont pas innocents tous les deux. Soit le majordome a menti, soit le cuisinier est innocent. Donc le majordome a menti, soit il est coupable”**

On pose $m$ “Le majordome est coupable” et $c$ “Le cuisinier est coupable”. La phrase se traduit donc par : 

> $\neg(\neg m \wedge \neg c) \wedge (m \vee \neg c)$.

## Exercice 5

Il y a 3 suspects : Adams, Brown et Clark. Adams dit que “Je ne l'ai pas fait. La victime était une vieille connaissance de Brown. Mais Clark la détestait.”