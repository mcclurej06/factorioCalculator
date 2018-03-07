package foo

val assemblerSpeed = .75
val farmspeed = 1.0
val bioprocessorSpeed = .75
val liquifierSpeed = 1.5
val algaeFarmSpeed = 1.0


val mudToSoil = Link(4, assemblerSpeed, Item.MUD to 1, Item.SOIL to 1)

val soilToTianaton = Link(60, farmspeed, Item.SOIL to 5, Item.TIANATON to 25 /*half to reprocess*/)
val tianatonToCelluloseFibre = Link(4, bioprocessorSpeed, Item.TIANATON to 10, Item.CELLULOSE_FIBRE to 12)

val mudSource = Link(60, 1.0, Item.NULL to 1, Item.MUD to 270)

val mineralizedWater = Link(1, liquifierSpeed, Item.CRUSHED_STONE to 10, Item.MINERAL_WATER to 100)
val algaeFarm = Link(20, algaeFarmSpeed, Item.MINERAL_WATER to 200, Item.GREEN_ALGAE to 40)
val liquifier = Link(3, liquifierSpeed, Item.GREEN_ALGAE to 10, Item.CELLULOSE_FIBRE to 5)
val celluloseFibreToWoodPellets = Link(4, assemblerSpeed, Item.CELLULOSE_FIBRE to 12, Item.WOOD_PELLETS to 2)

data class Link(
        val time: Int,
        val craftingSpeed: Double,
        val cost: Pair<Item, Int>,
        val produces: Pair<Item, Int>
) {
    val name: String = "${cost.first.name}->${produces.first.name}"
}