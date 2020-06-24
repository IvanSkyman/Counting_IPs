//Переписывает айпи адреса из одного файла в другой, конвертируя их при этом в номера (не просто убирая точки а учитывая разрядность чисел)
//Далее читает второй файл и переписывает в третий, при этом осуществляется 1й этап пузырьковой сортировки без ошибки
//2й этап пузырьковой сортировки переписывает номера из третьего файла во втророй и т.д. то есть 2й и 3й файл меняются местами при проходах пузырьковой сортировки
//При каждом проходе пузырьковой сортировки считается число перестановок (свопов)
//Пузырьковая сортировка осуществляется до тех пор, пока число перестановок не станет равным нулю
//После окончания всех этапов пузырьковой сортировки идёт подсчёт уникальных чисел в последнем файле (так сказать 2м или 3м), путм сравнения двух соседних чисел.
//Если два соседних числа не равны, то счётчик уникальных айпи номеров увеличивается на единицу.


import java.io.File

//Функция переписывания айпи адресов из одного файла в числа в другом файле
fun conv_ip_addresses_to_numbers_v1_2 (file_to_convert: String, converted_file_ip: String){  //Входные данные - имя файла в котором айпи адреса, и имя файла,
    //в который нужно записать конвертрованные в числа айпи адреса
    var file_to_convert = File(file_to_convert) //Исходный файл, из которого берутся неконвертированные айпи адреса
    var converted_file_ip = File(converted_file_ip) //Файл, в который записываются конвертированные в числа айпи адреса
    file_to_convert.forEachLine { line -> converted_file_ip.appendText(convert_IP_to_number_v1_2 (line) + "\n") }
}
//Конец функции переписывания айпи адресов из одного файла в числа в другом файле

//Функция одного прохода пузырьковой сортировки. Берёт числа из одного файла построчно и переписывает в другой файл, возвращает число перестановок
fun bubble_one_step_v1_2 (filename_1:String, filename_2:String, stage:Boolean, iteration:Long) : Long { //iteration только для информирования
    var file_1 = File(filename_1) //Файл, из которого начинается первый проход пузырьковой сортировки
    var file_2 = File(filename_2) //Файл, в который записывается первый проход пузырьковой сортировки

    var number2_string: String = "0"  //Сроковый формат последнего прочитанного из 1-го файла числа
    var number1_string: String = "0"//Строковый формат предпоследнего прочитанного из 1-го файла числа
    var number2: Long = 0L //Числовой формат последнего прочитанного из 1-го файла числа
    var number1: Long = 0L //Числовой формат предпоследнего прочитанного из 1-го файла числа
    var line_counter: Long = 0L //Счётчик строк в исходном файле для пузырьковой сортировки
    var div : Long = 10000000L //Периодичность, с которой программа будет выдавать перемнную line_counter
    var line_counter_div : Long = 0L //Остаток от деления переменной Line_counter на div

    var swap_counter1: Long = 0L //Счётчик замены местами при пузырьковой сортировки

    //отладочный код
    //print("Iteration="); println(iteration)
    //конец отладочного кода
    file_1.forEachLine { line ->  //Считываем каждую строчку из файла, в котором нужно сделать один проход методом пузырьковой сортировки
        line_counter++  //Считаем номер строки в исходном файле, в котором нужно сделать один проход пузырьковой сортировки
        line_counter_div = line_counter % div

        //Код для сведения, что программа работает
        if ((line_counter > 0) && (line_counter_div == 0L)) {
            print("Идёт "); print(iteration); print(" проход пузырьковой сортировки, linecounter="); println(line_counter)
        }
        //Конец кода для сведения, что программа работает

        if (number2 >= number1) { //Если последнее прочитанное число больше предпоследнего, то вписываем на новую строку в file_2 предпоследнее число

            //отладочный код
            /*
            print ("number_ip="); print(number1_string); print (" number2="); print(number2); print (" number1="); print(number1);
            print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2>=n1")
            println();
             */
            //конец отладочного кода



            if (line_counter > 2L) { //Запись в результативный файл идёт только после того, как line_counter станет равным 3,
                //так как первые 2 цикла идёт присваивание для number1 и number2
                //swap_counter++
                //file_2.appendText(number1_string + " number2=" + number2 + " number1=" + number1 + " line_counter=" + line_counter + " swap_counter=" + swap_counter + "\n")
                file_2.appendText(number1_string + "\n")

                //Запись в файл последнего прочитанного числа (в предыдущем цикле предпоследнее и последнее число свапнуты,
                // так как последнее число было больше предпоследнего)
            }
            number1 = number2   //Если последнее прочитанное число больше предпоследнего, то присваиваем предпоследнему числу последнее, и
            //тогда в file_2 будет записываться предпоследнее число уже в следующем цикле, и в следующем же цикле последнее число
            //станет предпоследним и будет сравниваться со следующим прочитанным числом из file_1
            number1_string = number1.toString() //Конвертация предпосленего числа в строку
            number2_string = line //Чтение следующего числа из file_1 (в данном цикле последнего из двух - последнего и предпоследнего)
            number2 = number2_string.toLong()   //Конвертация последнего числа в строку
            //swap_counter++
        } else { //Если последнее прочитанное число меньше предпоследнего или равно ему, то вписываем на новую строку в file_2 предпоследнее число

            //Отладочный код
            /*
            print ("number_ip="); print(number2_string); print (" number2="); print(number2); print (" number1="); print(number1);
            print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2<n1")
            println();

             */
            //Конец отладочного код

            if (line_counter > 2L) { //Запись в результативный файл идёт только после того, как line_counter станет равным 3,
                // так как первые 2 цикла идёт присваивание для number1 и number2
                //file_2.appendText(number2_string + " number2=" + number2 + " number1=" + number1 + " line_counter=" + line_counter + "swap_counter=" + swap_counter + "\n")
                file_2.appendText(number2_string + "\n")
                //Запись в файл предпоследнего прочитанного числа (в предыдущем цикле предпоследнее и последнее число несвапнуты,
                // так как последнее число было больше предпоследнего)

                swap_counter1++
            }
            number1_string = number1.toString() //Конвертация предпосленего числа в строку
            number2_string = line  //Чтение следующего числа из file_1 (в данном цикле последнего из двух - последнего и предпоследнего)
            number2 = number2_string.toLong() //Конвертация последнего числа в строку
            //swap_counter++

        }

    }
    //Это добавка, чтобы записать последние 2 числа в правильном порядке в конец file_2
    if (number2 >= number1) {
        /*
        file_2.appendText(number1_string + " number2=" + number2 + " number1="+number1 + " swap_counter=" + swap_counter + "\n")
        file_2.appendText(number2_string + " number2=" + number2 + " number1="+number1 + " swap_counter=" + swap_counter + "\n")
        */
        file_2.appendText(number1_string  + "\n")

        //Отладочный код
        /*
        print ("number_ip="); print(number1_string); print (" number2="); print(number2); print (" number1="); print(number1);
        print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2>=n1 prelast")
        println();

         */
        //Конец отладочного кода

        file_2.appendText(number2_string  + "\n")

        //Отладочный код
        /*
        print ("number_ip="); print(number2_string); print (" number2="); print(number2); print (" number1="); print(number1);
        print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2>=n1 last")
        println();

         */
        //Конец отладочного кода

    } else {
        swap_counter1++
        /*
        file_2.appendText(number2_string + " number2=" + number2 + " number1="+number1 + " swap_counter=" + swap_counter + "\n")
        file_2.appendText(number1_string + " number2=" + number2 + " number1="+number1 + " swap_counter=" + swap_counter + "\n")
         */
        file_2.appendText(number2_string + "\n")

        //Отладочный код
        /*
        print ("number_ip="); print(number2_string); print (" number2="); print(number2); print (" number1="); print(number1);
        print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2<n1 prelast")
        println();

         */
        //Конец отладочного кода

        file_2.appendText(number1_string + "\n")

        //Отладочный код
        /*
        print ("number_ip="); print(number1_string); print (" number2="); print(number2); print (" number1="); print(number1);
        print (" line_counter="); print(line_counter); print (" swap_counter1="); print(swap_counter1); print(" n2<n1 last")
        println();

         */
        //Конец отладочного кода

    }
    //Это добавка, чтобы записать последние 2 числа в правильном порядке в конец file_2

    file_1.writeText("") //очищаем исходный файл
    return swap_counter1; //Возвращаем количество перестановок после одного прохода пузырьковой сортировки
}
//Конец функции одного прохода пузырьковой сортировки.


//Функция перевода IP-номера в число с с учётом разрядности (например 123.8.11.12 = 123008011012)
fun convert_IP_to_number_v1_2 (IP_address:String):String{


    var i:Int = 0
    var S1:String = ""
    var S2:String = ""
    var S3:String = ""
    var S4:String = ""
    var S5:String = ""
    var S6:String = ""
    var S1_Long:Long = 0L
    var S3_Long:Long = 0L
    var S5_Long:Long = 0L
    var S6_Long:Long = 0L
    var IP_address_Number:Long = 0L
    i = IP_address.indexOf(".")
    S1 = IP_address.substring(0,i)
    S1_Long = 1000000000*S1.toLong()
    S2 = IP_address.substring(i+1,IP_address.length)
    i = S2.indexOf(".")
    S3 = S2.substring(0,i)
    S3_Long = 1000000*S3.toLong()
    S4 = S2.substring(i+1,S2.length)
    i = S4.indexOf(".")
    S5 = S4.substring(0,i)
    S5_Long = 1000*S5.toLong()
    S6 = S4.substring(i+1,S4.length)
    S6_Long = S6.toLong()
    IP_address_Number = S1_Long + S3_Long +S5_Long +S6_Long
    return IP_address_Number.toString()
}
//Конец функции перевода IP-номера в число с с учётом разрядности

//Функция подсчёта уникальных номеров в файле
fun calculate_unique_numbers_2 (filename : String): Long {
    var file_1 = File(filename)
    var number1_string: String = "0"
    var number2_string: String = "0"
    var number1: Long = 0L
    var number2: Long = 0L
    var unique_counter: Long = 1L

    var line_counter: Long = 0L //Счётчик строк в конечном файле после всех проходов пузырьковой сортировки. Нужен только, чтобы видеть, что программа работает
    var div : Long = 10000000L //Периодичность, с которой программа будет выдавать перемнную line_counter
    var line_counter_div : Long = 0L //Остаток от деления переменной Line_counter на div

    //Код для сведения, что программа работает
    println("Начался подсчёт уникальных номеров в полностью отсортированном файле")
    //Конец кода для сведения, что программа работает

    file_1.forEachLine { line ->


        //Код для сведения что прграмма работает
        line_counter++  //Считаем номер строки в исходном файле, в котором нужно сделать один проход пузырьковой сортировки
        line_counter_div = line_counter % div
        if ((line_counter > 0) && (line_counter_div == 0L)) {
            print("Идёт подсчёт уникальных номеров, linecounter="); println(line_counter)
        }
        //Конец кода ля сведения, что программа работает

        number1 = number2
        number2_string = line //Запись числа из очередной строки в номер 2
        number2 = number2_string.toLong()
        if (number2 != number1) {
            unique_counter++
        }
        //Отладочный код
        /*
        print("line="); print(line); print(" number1="); print(number1); print("number2="); print(number2); print (" un_counter="); println(unique_counter)

         */
        //Конец отладочного кода
    }
    return (unique_counter)
}
//Конец функции подсчта уникальных номеров в файле

fun main (args:Array<String>) {
    var SourceFile = File("ip_addresses")  //Файл с айпи адресами
    // SourceFile.writeText("");

    var Filename_initial : String  //Файл с конвертированными в числа айпи адресами. В дальнейшем в него будут записываться чётные проходы пузырьковой сортировки
    Filename_initial = "Filename_initial_v4.txt"
    var FileInitial = File(Filename_initial)
    FileInitial.writeText("");

    var Filename_converted : String
    Filename_converted = "Filename_converted_v4.txt" //Файл, в который записываютс нечтные проходы пузырьковой сортировки
    var FileConverted = File(Filename_converted)
    FileConverted.writeText("")

    var swap_counter : Long = 1 //Счётчик перестановок при пузырьковой сортировке. Начальное значение 1, чтобы запустить цикл пузырьковой сортировки
    //Проходы пузырьковой сортировки продолжаются, пока число перестановок не станет равным нулю
    var iteration : Long = 0  //Счтчик проходов пузырьковой сортировки (не используется в алгоритме сортировки, просто для сведения)
    var stage: Boolean = false  //Показывает, какой файл является исходным, а како результирующим при пузырьковой сортировке
    //Если false, то сортировка идёт из initial в converted, а если true, то наоборот

    var number_of_unique_ips : Long = 0 //Число униклаьных айпи номеров (заводится переменная, потому что в функции присутствует отладочный код)

    var line_counter: Long = 0L //Счётчик строк при конвертации айпи адресов. Нужен только, чтобы видеть, что программа работает
    var div : Long = 5000L //Периодичность, с которой программа будет выдавать перемнную line_counter
    var line_counter_div : Long = 0L //Остаток от деления переменной Line_counter на div

    //Код для сведения (чтобы знали, что программа работает)
    println("Начинается конвертирование IP-номеров в числа")
    //Конец кода для сведения

    SourceFile.forEachLine {



            line -> FileInitial.appendText(convert_IP_to_number_v1_2(line) + "\n")

        //Код для сведения что прграмма работает
        line_counter++  //Считаем номер строки в исходном файле, в котором нужно сделать один проход пузырьковой сортировки
        line_counter_div = line_counter % div
        if ((line_counter > 0) && (line_counter_div == 0L)) {
            print("Идёт конвертация IP-адресов в числа, linecounter="); println(line_counter)
        }
        //Конец кода ля сведения, что программа работает

    } //Конвертация ip-номеров в числа

    //Код для сведения (чтобы знали, что программа работает)
    println("Конвертирование IP-номеров в числа закончено, начинается цикл пузырьковой сортировки")
    //Конец кода для сведения

    //Цикл пузырьковой сортировки
    while (swap_counter > 0) {  //Пузырьковая сортировка продолжается до тех пор, пока число перестановок в результате прохода не станет равным нулю
        //for (i in 1..5){
        if (stage == false) { //Если стадия false то проход пузырьковой сортировки идёт из initial в converted
            swap_counter = bubble_one_step_v1_2(Filename_initial, Filename_converted, stage, iteration)  //Проход пузырьковой сортировки из initial в converted,
            //возвращает число перестановок при одном проходе пузырьковой сортировки

            stage = true //Поменять стадию, чтобы в следующий раз проход пузырьковой сортировки шёл из converted в initial
            iteration++  //Счётчик количества проходов (не используется в алгоритме сортировки, просто для сведения)
            //Filename_initial.writeText("")

            //Отладочный код
            /*
            print("swap_counter= ")
            println(swap_counter)
            print("iteration=")
            println(iteration)
            print("stage=")
            println(stage)
             */
            //Конец отладочного кода

            //Код для сведения (чтобы знали, что программа работает)
            print("Прошёл "); print(iteration); println("й проход пузырьковой сортировки")
            //Конец кода для сведения

        }

        else {
            swap_counter = bubble_one_step_v1_2(Filename_converted, Filename_initial, stage, iteration) //Проход пузырьковой сортировки из converted в initial,
            //возвращает число перестановок при одном проходе пузырьковой сортировки

            stage = false //Поменять стадию, чтобы в следующий раз проход пузырьковой сортировки шёл из initial в converted
            iteration++  //Счётчик количества проходов (не используется в алгоритме сортировки, просто для сведения)

            //Отладочный код
            /*
            print("swap_counter= ")
            println(swap_counter)
            print("iteration=")
            println(iteration)
            print("stage=")
            println(stage)
             */
            //Конец отладочного кода

            //Код для сведения (чтобы знали, что программа работает)
            print("Прошёл "); print(iteration); println("й проход пузырьковой сортировки")
            //Конец кода для сведения
        }
    }
    //Конец цикла пузырьковой сортировки

    //Печать результата

    if (stage == true) {
        number_of_unique_ips = calculate_unique_numbers_2(Filename_converted)
        print("Number of unique ip's is "); println(number_of_unique_ips)
    }
    else {
        number_of_unique_ips = calculate_unique_numbers_2(Filename_initial)
        print("Number of unique ip's is "); println(number_of_unique_ips)
    }
    //Конец печати результата
}