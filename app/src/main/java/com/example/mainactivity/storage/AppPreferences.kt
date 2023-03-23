package com.example.mainactivity.storage

import android.content.Context
import android.content.SharedPreferences

//пакет STORAGE - хранилище
class AppPreferences(ctx: Context) {
    /* (ПРЕДПОЧТЕНИЯ)Присвоили переменной тип данных абстрактного класса Context,
    он необходим для передачи конструктора класса при создании экземпляра класса.
    Contex служидт абстрактным классом в структуре приложения Android.
    Реализация контекста обеспечивается системой Android.
    Класс Сontext позволяет получить доступ к ресурсам конкретного приложения.
    (Сontext) Он так же предоставляет доступ к вызовам для операций
    на уровне приложений, таких как запуск, отправка широковещательных сообщений
    и получение намерений.
    Contex, поддерживает доступ к методу .getSharedPreferences(),
    который получает файл настроек.
    Файл настроек идентифицируется по имени в строке, переданной как
    как первый аргумент метода getSharedPreferences*/

    var data: SharedPreferences = ctx.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)
 /*  Тип данных (ШардПрефренс - коллективные предпочтения, поделенные предпочтения)
 Я создал данную переменную, для обращения к ней в фукциях, которые потребуются мне
 для обнуления очков, записи максимальных очков, записи текущих очков.
 Тип данных SharedPreferences позволяет обеспечить храниение, организацию доступа,
 модификацию данных(?) и сохранение данных в наборах пар ключ-значение.
 Позволяет одной переменной иметь разные ключи - значения и в зависимости от их
 изменения, осуществлять различные манипуляции в Активити, вызывая конкретное
 измененное значение переменной.
 */
    fun saveHighScore(highScore: Int) {
        data.edit().putInt("HIGH_SCORE", highScore).apply()
    }
    /* fun saveHighScore()(СКОР) принимает целое число(наибольшое кол-во очков),
    которые будут сохраняться, когда единственный аргумент data.edit() возвратит
    объект Editor (редактор), разрешающий изменение файла настроек.
    (как выглядит ШАРДПРЕФРЕНС) public abstract SharedPreferences.Editor
                                     putInt(String key, int value )
    putInt()(ПОМЕСТИТЬ Int) - это метод объекта Editor (редактор), вызывается для сохранения
    целого числа в файле настроек.Первый аргумент строка представляющий ключ,
    который используется для доступа к сохраненному значению.
    Второй аргумент метода, целое число, которое необходимо сохранить
    (в нашем случае наибольшое кол-во очков) */

    fun getHighScore(): Int {
        return data.getInt("HIGH_SCORE", 0)
    }
    /* fun getHighScore() возвращает наибольшее кол-во очков при вызове данных
    с помощью функции getInt()(ПОЛУЧИТЬ Int).
    getInt() - реализуется с помощью интерфейса SharedPreferences (ШардПрефренс)
    и поддерживает доступ (для чтения) к сохраненному целочисленному значению.
    HIGH_SCORE -уникальный идентификатор значения, которое неоходимо получить.
    0 - второй аргумент функции, указывает заданное по умолчанию значение,
    которое должно возвращаться сценарием, если в сценарии отсутствует
    соответствующее указанному ключу значение. */

    fun clearHighScore() {
        data.edit().putInt("HIGH_SCORE", 0).apply()
    }
    /*   fun clearHighScore() - перезаписывает нулем значение,
    соответствующее ключу HIGH_SCORE.(сбрасываем значение очков до нуля) */
}