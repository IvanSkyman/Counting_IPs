
//Вывели обработку диапазона в отдельную функцию
//Работает для диапазонов с крупными числами
//Сменили алгоритм с контрольным массивом. Если число из файла находится в нужном диапазоне,
//Оно записывается в контрольный массив по индексу, равному данному числу со смещением (если необходимо)
//но только если оно там уже не записано. Если записывается, счетчик увеличивается на 1
//Проверен на маленьких и больших положительных и отрицательных диапазонах
import java.io.File

fun main() {
    val InputFilename = "ip_addresses"
    val LogFile = File("LogFile.txt")
    var unique_number : Long = 0
    var unique_number_from_range : Int //= 0

    val range_low_1st : Int = 0
    val range_high_1st : Int = 429499999

    val range_low_2nd : Int = 429500000
    val range_high_2nd : Int = 858999999

    val range_low_3rd : Int = 859000000
    val range_high_3rd : Int = 1288499999

    val range_low_4th : Int = 1288500000
    val range_high_4th : Int = 1717999999

    val range_low_5th : Int = 1718000000
    val range_high_5th : Int = 2147483647

    val range_low_6th : Int = -2147483648
    val range_high_6th : Int = -1718000000

    val range_low_7th : Int = -1717999999
    val range_high_7th : Int = -1288500000

    val range_low_8th : Int = -1288499999
    val range_high_8th : Int = -859000000

    val range_low_9th : Int = -858999999
    val range_high_9th : Int = -429500000

    val range_low_10th : Int = -429499999
    val range_high_10th : Int = -1

    LogFile.writeText("")

    print ("1st range started"); println(" ($range_low_1st..$range_high_1st)")
    LogFile.appendText("1st range started"); LogFile.appendText(" ($range_low_1st..$range_high_1st)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_1st,range_high_1st)  //вычисляем количество уникальных айпи-адресов из заданного диапазона
    unique_number = unique_number + unique_number_from_range  //суммируем уникальных айпи-адресов из заданного диапазона с общим числом уникальных айпи-адресов
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("2nd range started"); println(" ($range_low_2nd..$range_high_2nd)")
    LogFile.appendText("2nd range started"); LogFile.appendText(" ($range_low_2nd..$range_high_2nd)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_2nd,range_high_2nd)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("3rd range started"); println(" ($range_low_3rd..$range_high_3rd)")
    LogFile.appendText("3rd range started"); LogFile.appendText(" ($range_low_3rd..$range_high_3rd)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_3rd,range_high_3rd)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("4th range started"); println(" ($range_low_4th..$range_high_4th)")
    LogFile.appendText("4th range started"); LogFile.appendText(" ($range_low_4th..$range_high_4th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_4th,range_high_4th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("5th range started"); println(" ($range_low_5th..$range_high_5th)")
    LogFile.appendText("5th range started"); LogFile.appendText(" ($range_low_5th..$range_high_5th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_5th,range_high_5th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("6th range started"); println(" ($range_low_6th..$range_high_6th)")
    LogFile.appendText("6th range started"); LogFile.appendText(" ($range_low_6th..$range_high_6th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_6th,range_high_6th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("7th range started"); println(" ($range_low_7th..$range_high_7th)")
    LogFile.appendText("7th range started"); LogFile.appendText(" ($range_low_7th..$range_high_7th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_7th,range_high_7th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("8th range started"); println(" ($range_low_8th..$range_high_8th)")
    LogFile.appendText("8th range started"); LogFile.appendText(" ($range_low_8th..$range_high_8th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_8th,range_high_8th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("9th range started"); println(" ($range_low_9th..$range_high_9th)")
    LogFile.appendText("9th range started"); LogFile.appendText(" ($range_low_9th..$range_high_9th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_9th,range_high_9th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")

    print ("5th range started"); println(" ($range_low_10th..$range_high_10th)")
    LogFile.appendText("10th range started"); LogFile.appendText(" ($range_low_10th..$range_high_10th)\n")
    unique_number_from_range = range_processing_v3(InputFilename, range_low_10th,range_high_10th)
    unique_number = unique_number + unique_number_from_range
    println ("unique_number_from_range=$unique_number_from_range")
    LogFile.appendText("unique_number_from_range=$unique_number_from_range \n")
    println ("unique_number=$unique_number")
    LogFile.appendText("unique_number=$unique_number \n")
}

//Функция подсчета уникальных номеров в файле из определенного диапазона
fun range_processing_v3(filename:String, low_range:Int, high_range:Int):Int{
    val SourceFile = File(filename) //Входной файл
    var a = IntArray(high_range - low_range + 1)  //Диапазон обрабатываемых значений
    var count: Int = 0  // счётчик при переборке элементов массива для сравнения с текущим числом
    var b:Int = 0 //Текущее считываемое число из файла
    var count_number:Int = 0 //счётчик числа уникальных номеров в заданном диапазоне
    var array_size: Int //=0 //Размер контрольного массива
    var index : Int //Индекс элемента контрольного массива при записи в него элементов
    var line_counter : Long = 0
    var line_counter_div : Long
    val div : Long = 50000000


    //Задаём контрольный массив
    array_size = high_range - low_range
    for (i in 0 .. array_size){
        a[i]=low_range - 1
    }
    //Закончили задавать контрольный массив

    SourceFile.forEachLine {line -> //Чтение каждой строки в файле

        line_counter++  //Считаем номер строки в исходном файле
        line_counter_div = line_counter % div
        if ((line_counter > 0L) && (line_counter_div == 0L)) {
            print("linecounter=$line_counter "); println(" count_number=$count_number") //Выводим счётчик с кратностью div, чтобы видеть, что программа работает
        }

        b = convert_ip_v3(line)  //Конвертация строки из файла в интежер


        if ((b <= high_range) && (b >= low_range)){  //проверяем, что число входит в заданный диапазон
            index = b - low_range  //вычисляем индекс в контрольном массиве для заданного числа (задаём смещение)

            if  (a[index] != b) {  //проверяем, не записано ли уже это число в массив (то есть не встречалось ли оно ранее)
                a[index] = b  //если это число не встрачалось ранее, записываем его в контрольный массив в соответствии индексу
                count++ //если это число не было ранее записано в контрольный массив, значит оно не встречалось ранее, значит увеличиваем счётчик на единицу
            }
        }


    }
    return(count) //число уникальных айпи-номеров (точнее их числовых эквивалентов) из заданного диапазона
}



fun convert_ip_v3 (IP_address: String) : Int{  //функция перевода айпи номера в число типа Int
//Если айпи-номер имеет вид A.B.C.D то число вычисляется по формуле A*256^3+B*256^2+C*256+D
    var i :Int
    var S1 : String
    var S1_Int : Int
    var S2 : String
    var S3 : String
    var S3_Int : Int
    var S4 : String
    var S5 : String
    var S5_Int : Int
    var S6 : String
    var S6_Int : Int
    var IP_address_Number : Int



    i = IP_address.indexOf(".")
    S1 = IP_address.substring(0,i)
    S1_Int = 16777216*S1.toInt()  //256^3=16777216
    S2 = IP_address.substring(i+1,IP_address.length)
    i = S2.indexOf(".")
    S3 = S2.substring(0,i)
    S3_Int = 65536*S3.toInt()
    S4 = S2.substring(i+1,S2.length)
    i = S4.indexOf(".")
    S5 = S4.substring(0,i)
    S5_Int = 256*S5.toInt()
    S6 = S4.substring(i+1,S4.length)
    S6_Int = S6.toInt()
    IP_address_Number = S1_Int + S3_Int +S5_Int +S6_Int
    return IP_address_Number
}

