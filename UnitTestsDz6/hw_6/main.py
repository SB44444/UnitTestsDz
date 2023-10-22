# This is a sample Python script.
from prog import Comparator

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    mylist1 = [1, 2, 3, 4, 5, 6, 1000]
    mylist2 = [18, 2.0, 3.8, 4, 5, 6]
    nums_list = Comparator(mylist1, mylist2)
    nums_list.arr_1 = mylist1
    nums_list.arr_2 = mylist2
    nums_list.compare_averages()
