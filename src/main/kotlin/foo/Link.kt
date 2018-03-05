package foo

val mineralizedWater = Link("mineralizedWater", 1, 1.5, Item.CRUSHED_STONE to 10, Item.MINERAL_WATER to 100)
val algaeFarm = Link("algaeFarm", 20, 1.0, Item.MINERAL_WATER to 200, Item.GREEN_ALGAE to 40)
val liquifier = Link("liquifier", 3, 1.5, Item.GREEN_ALGAE to 10, Item.CELULOSE_FIBRE to 5)
val assembler = Link("assembler", 4, .5, Item.CELULOSE_FIBRE to 12, Item.WOOD_PELLETS to 2)

data class Link(
        val name: String,
        val time: Int,
        val craftingSpeed:Double,
        val cost: Pair<Item, Int>,
        val produces: Pair<Item, Int>
)