from __future__ import annotations

""" Класс принимает в качестве аргументов списки чисел int или float """


class Comparator:
    def __init__(self, arr_1: list[int | float], arr_2: list[int | float]):
        self.arr_1 = arr_1
        self.arr_2 = arr_2

    """ Функция расчета среднего и если список пустой, присваивается нулевое значение """

    def count_average(self):
        avarage1 = 0
        if self.arr_1 != 0:
            avarage1 = sum(self.arr_1) / len(self.arr_1)

        avarage2 = 0
        if self.arr_2 != 0:
            avarage2 = sum(self.arr_2) / len(self.arr_2)

        return avarage1, avarage2

    """Функция сравнения среднего значения"""

    def compare_averages(self):
        avarage1, avarage2 = self.count_average()
        if avarage1 > avarage2:
            print('"Первый список имеет большее среднее значение"')
        elif avarage1 < avarage2:
            print('"Второй список имеет большее среднее значение"')
        else:
            print('"Средние значения равны"')
