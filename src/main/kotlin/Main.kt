
fun main(args: Array<String>) {
    var survey = arrayOf("TR", "RT", "TR")
    var choices = intArrayOf(7, 1, 3)

    println(solution(survey, choices))
}

fun solution(survey : Array<String>, choices : IntArray): String {
    var answer = ""
    var result = IntArray(4)
    var sum = ArrayList<String>()
<<<<<<< HEAD
        survey.mapIndexed{index, i ->
=======
          survey.mapIndexed{index, i ->
>>>>>>> 53ebe87606cc36dba848fe5761337738c8d8f0a9
            if( 4 < choices[index] ){
                sum.add("${i.last()} = ${choices[index] - 4}")
            }
            else if ( 4 > choices[index]) {
                sum.add("${i.first()} = ${convert(choices[index])}")
            }
            else {}
        }


    sum.mapIndexed{index, s ->
        when(s.first()){
            'T' -> result[0]-= s.last().toString().toInt()
            'R' -> result[0]+= s.last().toString().toInt()
            'C' -> result[1]+= s.last().toString().toInt()
            'F' -> result[1]-= s.last().toString().toInt()
            'J' -> result[2]+= s.last().toString().toInt()
            'M' -> result[2]-= s.last().toString().toInt()
            'A' -> result[3]+= s.last().toString().toInt()
            'N' -> result[3]-= s.last().toString().toInt()
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