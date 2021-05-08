# RPG-Java-Game
An RPG style Java game in which two automated armies comprised of different enemy types battle (turn-based style) until there is a winner. This is a text based, console app.

## Game Rules Summary

- Create 2 armies, each consisting of 20 troops (order as described above). Print out the army.
- Each round, pick the next troop in line from each army to battle
- The attacking troop uses its damage amount to lower the defender’s health.
- Damage is halved if the attacker hits a target which is not his preferred target
- There 1 attack per side per round
- If any troop health drops below 0 or lower, it is dead and is no longer used in rounds
- Log outputs each round on what happened
- Players battle each other until no troops are left on one side
- Print out remaining troops and health of winning army 
- Pick the most outstanding troop in the winning army (the most outstanding troop is the first troop in the army, whose total damage amount has the longest run of consecutive 1s in its binary representation)

### Enemy Types
| Name | Type | Damage | Health | Preferred Target |
| :------------- | :------------- | :------------- | :------------- | :------------- |
| Monkey | Ground | 6 | 50 | Ground |
| Flying Monkey | Air | 6 | 50 | Air |
| Wizard | Ground | 6 | 60 | Air and Ground |
| Balloon | Air | 8 | 55 | Ground |
