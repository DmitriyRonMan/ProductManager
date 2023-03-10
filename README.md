**Задание 1.** Менеджер товаров (обязательное к выполнению)
Вам необходимо реализовать менеджер товаров, который умеет:

+ добавлять товары в репозиторий, 
+ искать товары.

Что нужно сделать:

1. Разработайте базовый класс <code>Product</code>, содержащий <code>ID</code>, название, стоимость.
2. Разработайте два унаследованных от <code>Product</code> класса: <code>Book</code> с текстовыми полями «название» и «автор» и <code>Smartphone</code> с текстовыми полями «название» и «производитель»; общие поля вынесите в родителя.
3. Разработайте репозиторий, позволяющий сохранять <code>Product</code>, получать все сохранённые <code>Product</code> и удалять по <code>ID</code>. Для этого репозиторий будет хранить у себя поле с типом <code>Product[]</code> (массив товаров).
4. Разработайте менеджера, который умеет добавлять <code>Product</code> в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий, а также с методом <code>publiс void add(Product product)</code> и методом поиска (см. ниже).

Домашнее задание к занятию «Исключительные ситуации и их обработка. Тестирование исключений»

**Задание 1.** NotFoundException (обязательное к выполнению)
Вы развиваете приложение с менеджером товаров, который мы рассматривали на лекции, и решили сделать так, чтобы при попытке удаления несуществующего объекта из репозитория генерировалось ваше исключение, а не <code>ArrayIndexOfBoundsException</code>.

Обратите внимание: это правильный подход, поскольку таким образом вы сообщаете через генерацию исключения, что это исключение, вписывающееся в вашу логику, а не ошибка программиста.

Что нужно сделать:

1. Возьмите проект с менеджером, репозиторием и товарами, мы его писали в рамках ДЗ про наследование.
2. Создайте класс исключения <code>NotFoundException</code>, отнаследовавшись от <code>RuntimeException</code>, и реализуйте как минимум конструктор с параметром-сообщением. Он будет просто вызывать суперконструктор предка, см. подсказку.
3. В методе удаления <code>removeById</code> сначала проверяйте, есть ли элемент. Для этого прямо из метода <code>removeById</code> вызывайте метод <code>findById</code>: если результат <code>null</code>, тогда выкидывайте исключение <code>NotFoundException</code>.
4. Напишите два автотеста на репозиторий: первый должен проверять успешность удаления существующего элемента, второй — генерации <code>NotFoundException</code> при попытке удаления несуществующего элемента.