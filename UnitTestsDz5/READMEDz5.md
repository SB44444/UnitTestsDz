**Unit-тесты (семинары)**  

**Урок 5. Другие виды тестирования**  

*Задание 1.*
Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.  


*Unit-тесты*  

Инфрастуктурные Unit-тесты проверяют корркетность работы каждой отдельной функции базового класса, возможны позитивные и негативные сценарии.  

@Test  
void testSetName(){  
Проверяет корркетность (эквивалентность, тип данных, количество вызовов) добавления в поле Name контакта класса Контакт -  Unit-тест  
}  

@Test
void testGetName(){
Проверяет корркетность (эквивалентность, тип данных, количество вызовов) получения из поля Name класса Контакт -  Unit-тест  
}  

@Test  
void testUpdateName(){  
Проверяет корркетность (эквивалентность, тип данных, количество вызовов) обновления в поля Name класса Контакт -  
Unit-тест  
}  

@Test  
void testDeleteName(){  
Проверяет корркетность (эквивалентность, тип данных, количество вызовов) улаления контакта из поля Name  класса Контакт - Unit-тест  
}  


Эксплуатационные Unit-тесты  проверяют корркетность и время работы каждой отдельной функции класса Репозиторий.

@Test  
void testAddContact(){  
Проверяет корркетность (эквивалентность, тип данных, количество вызовов) добавления контакта в список класса Репозиторий -  Unit-тест  
}  

@Test  
void testGetAllContact(){  
Проверяет корркетность (размер списка, количество вызовов) получения списка из класса Репозиторий - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testGetByNameContact(){  
Проверяет корркетность (эквивалентность, количество вызовов) получения контакта по имени из списка класса Репозиторий - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testUpdateByNameContact(){  
Проверяет корркетность (эквивалентность, количество вызовов) обновления контакта по имени из списка класса Репозиторий - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testDeleteByNameContact(){  
Проверяет корркетность (эквивалентность, количество вызовов) улаления контакта по имени из списка класса Репозиторий - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testTimeAddContact(){  
Проверяет время добавления контакта в список класса Репозиторий -  Unit-тест  
}  

@Test  
void testGetAllContact(){  
Проверяет время вывода всего списка контактов - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testUpdateByNameContact(){  
Проверяет время обновления контакта - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

@Test  
void testDeleteByNameContact(){  
Проверяет время улаления контакта - Unit-тест  (Для изоляции зависимости от класса Контакт используется mock заглушка)  
}  

*Интеграционные тесты*

@Test  
void testGetByNameContactFake(){  
Проверяет эквивалентность получения контакта по имени из списка класса Репозиторий - (Для изоляции зависимости от класса Контакт используется fake-объект класса Контакт) - Интеграционный тест  
}  

@Test  
void testGetAllContactFake(){  
Проверяет эквивалентность получения списка из класса Репозиторий (Для теста используется fake-объект класса Контакт) - Интеграционный тест  
}  

@Test  
void testUpdateByNameContactFake(){  
Проверяет эквивалентность обновления контакта по имени (Для теста используется fake-объект класса Контакт) - Интеграционный тест  
}  

@Test  
void testDeleteByNameContactFake(){  
Проверяет эквивалентность удаления контакта из списка (Для теста используется fake-объект класса Контакт) - Интеграционный тест  
}  

*Сквозные тесты*  

@Test  
void testGetByNameContactReal(){  
Проверяет время, коркетность и эквивалентность добавления, получения и удаления контакта - (Для теста используется реальный объект класса Контакт) - Сквозной тест  
}

@Test  
void testGetAllContactReal(){  
Проверяет время, корркетность и эквивалентность добавления, получения и удаления списка контактов - (Для теста используется реальный список объектов класса Контакт) - Сквозной тест  
}  


*Задание 2.*  
Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) и объяснить, почему вы так решили.  

1. Проверка того, что функция addContact корректно добавляет новый контакт в список контактов.  
   Такой тест относится к Unit-тестам, т.к. проверяет корркетность работы отдельной функции addContact не затрагивая другие функции и зависимости.  


2. Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов.  
   Такой тест относится к Интеграционным тестам, т.к. проверяет корркетность совместной работы функций зависимых классов в пределах одного модуля пользовательского интерфейса.  


3. Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление.  
  Такой тест относится к сквозным тестам, т.к. проверяет работу всего рабочего цикла затрагивая все функции управления контактами.  