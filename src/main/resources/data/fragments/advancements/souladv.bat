@echo off

set mobs=allay axolotl bat camel cat chicken cod cow donkey frog glow_squid horse mooshroom mule ocelot parrot pig pufferfish rabbit salmon sheep skeleton_horse sniffer snow_golem squid strider tadpole tropical_fish turtle villager wandering_trader bee cave_spider dolphin drowned enderman fox goat iron_golem llama panda piglin polar_bear spider trader_llama wolf zombified_piglin blaze creeper elder_guardian endermite evoker ghast guardian hoglin husk magma_cube phantom piglin_brute pillager ravager shulker silverfish skeleton slime stray vex vindicator warden witch wither_skeleton zoglin zombie zombie_villager
echo { > "soul.json"
echo   "display": { >> "soul.json"
echo     "icon": { >> "soul.json"
echo       "item": "fragments:sheep_soul" >> "soul.json"
echo     }, >> "soul.json"
echo     "title": { >> "soul.json"
echo       "translate": "advancements.fragments.soul.title" >> "soul.json"
echo     }, >> "soul.json"
echo     "description": { >> "soul.json"
echo       "translate": "advancements.fragments.soul.description" >> "soul.json"
echo     }, >> "soul.json"
echo     "frame": "task", >> "soul.json"
echo     "show_toast": true, >> "soul.json"
echo     "announce_to_chat": true, >> "soul.json"
echo     "hidden": false >> "soul.json"
echo   }, >> "soul.json"
echo   "parent": "fragments:shears", >> "soul.json"
echo   "criteria": { >> "soul.json"
echo     "diamond": { >> "soul.json"
echo       "trigger": "minecraft:inventory_changed", >> "soul.json"
echo       "conditions": { >> "soul.json"
echo         "items": [ >> "soul.json"
echo           { >> "soul.json"
echo             "items": [ >> "soul.json"

for %%i in (%mobs%) do (
    echo              "fragments:%%i_soul", >> "soul.json"
)

echo             ] >> "soul.json"
echo           } >> "soul.json"
echo         ] >> "soul.json"
echo       } >> "soul.json"
echo     } >> "soul.json"
echo   } >> "soul.json"
echo } >> "soul.json"
