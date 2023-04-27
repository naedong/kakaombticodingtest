
fun main(args: Array<String>) {
    var survey = arrayOf("TR", "RT", "TR")
    var choices = intArrayOf(7, 1, 3)

    println(solution(survey, choices))
}

fun solution(survey : Array<String>, choices : IntArray): String {
    var answer = ""
    var result = IntArray(4)
    var sum = ArrayList<String>()
    survey.mapIndexed { index, s ->
        if(choices[index] > 4){
            when(s.last()){
                'A' ->  sum.add("A = ${choices[index] - 4}")
                'C' -> sum.add("C = ${choices[index] - 4}")
                'F' ->  sum.add("F = ${choices[index] - 4}")
                'M'  ->  sum.add("M = ${choices[index] - 4}")
                'R'  ->  sum.add("R = ${choices[index] - 4}")
                'T'  ->  sum.add("T = ${choices[index] - 4}")
                'J'  ->  sum.add("J = ${choices[index] - 4}")
                'N'  ->  sum.add("N = ${choices[index] - 4}")
                else -> println("Index ${s.last()}")
            }
        }
        else if (choices[index] < 4){
            when(s.first()){
                'A' ->  sum.add("A = ${convert(choices[index]) }")
                'C' -> sum.add("C = ${convert(choices[index]) }")
                'F' ->  sum.add("F = ${convert(choices[index]) }")
                'M'  ->  sum.add("M = ${convert(choices[index]) }")
                'R'  ->  sum.add("R = ${convert(choices[index]) }")
                'T'  ->  sum.add("T = ${convert(choices[index]) }")
                'J'  ->  sum.add("J = ${convert(choices[index]) }")
                'N'  ->  sum.add("N = ${convert(choices[index])}")
                else -> println("Index ${s.last()}")
            }
        } else {
            when(s.first()){
                'A' ->  sum.add("A = 0")
                'C' -> sum.add("C = 0")
                'F' ->  sum.add("F = 0")
                'M'  ->  sum.add("M = 0")
                'R'  ->  sum.add("R = 0")
                'T'  ->  sum.add("T = 0")
                'J'  ->  sum.add("J = 0")
                'N'  ->  sum.add("N = 0")
                else -> println("Index ${s.last()}")
            }
        }

    }


    for( t in sum.indices ){
        if(sum[t].first() == 'T' || sum[t].first() == 'R'){
            if(sum[t].first() == 'T') result[0] -= sum[t].last().toString().toInt()
            else if (sum[t].first() == 'R') result[0] += sum[t].last().toString().toInt()
        }
        else if(sum[t].first() == 'C' || sum[t].first() == 'F'){
            if(sum[t].first() == 'F') result[1] -= sum[t].last().toString().toInt()
            else if (sum[t].first() == 'C') result[1] += sum[t].last().toString().toInt()
        }
        else if(sum[t].first() == 'J' || sum[t].first() == 'M'){
            if(sum[t].first() == 'M') result[2] -= sum[t].last().toString().toInt()
            else if (sum[t].first() == 'J') result[2] += sum[t].last().toString().toInt()
        }
        else if(sum[t].first() == 'A' || sum[t].first() == 'N'){
            if(sum[t].first() == 'N') result[3] -= sum[t].last().toString().toInt()
            else if (sum[t].first() == 'A') result[3] += sum[t].last().toString().toInt()
        }
    }


    result.mapIndexed { index, e ->
        answer += when(index) {
            0 ->  if(e >= 0 )  "R" else   "T"
            1 ->  if(e >= 0) "C" else   "F"
            2 ->  if(e >= 0)  "J" else   "M"
            else ->  if(e >= 0)  "A" else   "N"
            }
    }

    answer += if(result[0] == null)  "R"
    else if (result[1] == null)  "C"
    else if (result[2] == null) "J"
    else if (result[3] == null)  "A"
    else { ""}
    return answer
}
fun convert(index : Int) : Int {
    return when(index){
        1 -> 3
        2 -> 2
        3 -> 1
        else -> index
    }
}
fun editSolution(survey: Array<String>, choices: IntArray) : String {
    val typeR = intArrayOf(0, 0)  // 라이언형, 튜브형
    val typeC = intArrayOf(0, 0)  // 콘형, 프로도형
    val typeJ = intArrayOf(0, 0)  // 제이지형, 무지형
    val typeA = intArrayOf(0, 0)  // 어피치형, 네오형


    survey.mapIndexed{index, i ->
      if(choices[index] < 4) {

      }


        when (i.last()) {
            'R' -> when (choices[index]) {
                1 -> typeR[0] += 3
                2 -> typeR[0] += 2
                3 -> typeR[0] += 1
            }
            'T' -> when(choices[index]){
                5 -> typeR[1] += 1
                6 -> typeR[1] += 2
                7 -> typeR[1] += 3
            }
            'C'-> when (choices[index]) {
                1 -> typeC[0] += 3
                2 -> typeC[0] += 2
                3 -> typeC[0] += 1
            }
            'F' -> when (choices[index]) {
                5 -> typeC[1] += 1
                6 -> typeC[1] += 2
                7 -> typeC[1] += 3
            }

            'J' -> when (choices[index]) {
                1 -> typeJ[0] += 3
                2 -> typeJ[0] += 2
                3 -> typeJ[0] += 1
            }
            'M' -> when(choices[index]){
                5 -> typeJ[1] += 1
                6 -> typeJ[1] += 2
                7 -> typeJ[1] += 3
            }
            'A' -> when(choices[index]){
                1 -> typeA[0] += 3
                2 -> typeA[0] += 2
                3 -> typeA[0] += 1
            }
            'N' -> when(choices[index]){
                5 -> typeA[1] += 1
                6 -> typeA[1] += 2
                7 -> typeA[1] += 3

            }
        }
    }

    println("${typeR.contentToString()}")
    println("${typeC.contentToString()}")
    println("${typeJ.contentToString()}")
    println("${typeA.contentToString()}")

    val result = StringBuilder()

    result.append(if (typeR[0] > typeR[1] || typeR[0] == null) "R" else "T")
    result.append(if (typeC[0] > typeC[1] || typeC[0] == null) "C" else "F")
    result.append(if (typeJ[0] > typeJ[1] || typeJ[0] == null) "J" else "M")
    result.append(if (typeA[0] > typeA[1] || typeA[0] == null) "A" else "N")

    return result.toString()
}
fun solutions(survey: Array<String>, choices: IntArray): String {
    val result = IntArray(4)
    survey.mapIndexed { index, s ->
        val i = when(s.first()) {
            'A' -> 3
            'C' -> 1
            'F' -> 1
            'M' -> 2
            'N' -> 3
            'R' -> 0
            'T' -> 0
            'J' -> 2
            else -> 0
        }
        result[i] += when {
            choices[index] == 4 -> 0
            choices[index] < 4 -> convert(choices[index])
            else -> choices[index] - 4
        }
    }
    return result.mapIndexed { index, e ->
        when(index) {
            0 -> if (e >= 0) "R" else "T"
            1 -> if (e >= 0) "C" else "F"
            2 -> if (e >= 0) "J" else "M"
            3 -> if (e >= 0) "A" else "N"
            else -> ""
        }
    }.joinToString("")
}

