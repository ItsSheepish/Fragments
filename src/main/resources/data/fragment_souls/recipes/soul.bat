@echo off

set mobs=allay axolotl bat camel cat chicken cod cow donkey frog glow_squid horse mooshroom mule ocelot parrot pig pufferfish rabbit salmon sheep skeleton_horse sniffer snow_golem squid strider tadpole tropical_fish turtle villager wandering_trader bee cave_spider dolphin drowned enderman fox goat iron_golem llama panda piglin polar_bear spider trader_llama wolf zombified_piglin blaze creeper elder_guardian endermite evoker ghast guardian hoglin husk magma_cube phantom piglin_brute pillager ravager shulker silverfish skeleton slime stray vex vindicator warden witch wither_skeleton zoglin zombie zombie_villager
for %%i in (%mobs%) do (
    echo { > "soul_%%i.json"
    echo   "type": "fragments:soul_infuser", >> "soul_%%i.json"
    echo   "ingredients": [ >> "soul_%%i.json"
    echo     { >> "soul_%%i.json"
    echo       "item": "fragments:%%i_soul" >> "soul_%%i.json"
    echo     }, >> "soul_%%i.json"
    echo     { >> "soul_%%i.json"
    echo       "item": "fragments:%%i_soul" >> "soul_%%i.json"
    echo     }, >> "soul_%%i.json"
    echo     { >> "soul_%%i.json"
    echo       "item": "fragments:%%i_soul" >> "soul_%%i.json"
    echo     }, >> "soul_%%i.json"
    echo     { >> "soul_%%i.json"
    echo       "item": "fragments:%%i_soul" >> "soul_%%i.json"
    echo     }, >> "soul_%%i.json"
    echo     { >> "soul_%%i.json"
    echo       "item": "minecraft:egg" >> "soul_%%i.json"
    echo     } >> "soul_%%i.json"
    echo   ], >> "soul_%%i.json"
    echo   "output": { >> "soul_%%i.json"
    echo     "item": "minecraft:%%i_spawn_egg", >> "soul_%%i.json"
    echo     "count": 1 >> "soul_%%i.json"
    echo   } >> "soul_%%i.json"
    echo } >> "soul_%%i.json"
)