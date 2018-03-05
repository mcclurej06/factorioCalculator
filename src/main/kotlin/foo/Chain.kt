package foo

class Chain(
        val links: List<Link>
) {
    fun process() {
        var currentIndex = 0

        var lastProducing = links[currentIndex].produces.second / (links[currentIndex].time.toDouble() / links[currentIndex].craftingSpeed)

        currentIndex += 1

        var processes = mutableListOf<Process>()

        while (currentIndex < links.size) {
            val current = links[currentIndex]
            var multiplier = 0
            var canSupport: Double
            do {
                multiplier += 1
                val producedPerSecond = lastProducing * multiplier
                val consumedPerSecond = current.cost.second / (current.time.toDouble() / current.craftingSpeed)
                canSupport = producedPerSecond / consumedPerSecond

            } while (canSupport != canSupport.toInt().toDouble())


            lastProducing = links[currentIndex].produces.second / (links[currentIndex].time.toDouble() / links[currentIndex].craftingSpeed)

            processes.lastOrNull()?.let { lastProcess: Process ->
                val leastCommonMultiple = lcm(lastProcess.second.second, multiplier)

                println("lcm for ${lastProcess.second.second} and $multiplier is $leastCommonMultiple")

                processes = processes.map {
                    val multiplier1 = leastCommonMultiple / lastProcess.second.second.toDouble()
                    it.update(multiplier1)
                }.toMutableList()

                multiplier = multiplier * (leastCommonMultiple / multiplier)
                canSupport = canSupport * (leastCommonMultiple / multiplier)
            }

            processes.add(foo.Process(links[currentIndex - 1].name to multiplier, current.name to canSupport.toInt()))

            currentIndex += 1
        }

        processes.forEach {
            println(it)
        }
    }
}

typealias Process = Pair<Pair<String, Int>, Pair<String, Int>>

fun Process.update(multiplier: Double): Process {
    println("updating $this")
    println("updating by $multiplier")
    val updated = foo.Process(first.first to (first.second * multiplier).toInt(), second.first to (second.second * multiplier).toInt())
    println("updated $updated")
    println()
    return updated
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
fun lcm(a: Int, b: Int) = a * b / gcd(a, b)