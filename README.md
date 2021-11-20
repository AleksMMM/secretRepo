# Youtube-qa-project
Проект по автотестам для моего ютуб канала.
В этом репозитаории содержатся UI Selenide + API Rest Assured автотесты

# UI тесты. Пакет appleInsider. Тест кейс от подписчика №1

1. Открыть сайт appleinsider.ru
2. Нажать на кнопку поиска сверху справа
3. Ввести текст "Чем iPhone 13 отличается от iPhone 12" и нажать Enter
4. В найденных статьях получить href атрибут первой найденной статьи
5. Убедиться, что href ссылка содержит слово Iphone 13 (обрати внимание как это слово выглядит в href ссылке)

# UI тесты. Пакет hh. Тест кейс от подписчика №2 
1) Открыть резюме, которое доступно только по ссылке: https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073
2) Получить информацию о профиле, используя HashMap или Class, в которой должны быть следующие атрибуты:
String sex, int age, String city, boolean confirmedPhoneNumber, boolean readyToRelocate;
3) Убедится, что ожидаемый результат и актуальный равны

Ожидаемый результат sex = "М", age = 25, city = "Санкт-Петербург", confirmedPhoneNubmer = true, readyToRelocate = false; 

# API тесты. Пакет api. Тесты для методов GET/POST/DELETE/PUT для Rest Assured с использованием Specifications

Тест 1

1. Используя сервис https://reqres.in/ получить список пользователей со второй(2) страницы
2. Убедиться что имена файлов-аватаров пользоваталей совпадают;
3. Убедиться, что email пользователей имеет окончание reqres.in;

Тест 2

1. Используя сервис https://reqres.in/ протестировать регистрацию пользователя в системе
2. Необходимо создание 2 тестов:
   - успешная регистрация
   - регистрация с ошибкой из-за отсутствия пароля
3. Проверить коды ошибок.

Тест 3
1. Используя сервис https://reqres.in/ убедиться, что операция LIST<RESOURCE> возвращает данные,
отсортированные по годам.

Тест 4
1. Используя сервис https://reqres.in/ попробовать удалить второго пользователя и сравнить статус-код
  
Тест 5
1. Используя сервис https://reqres.in/ обновить информацию о пользователе и сравнить дату обновления с текущей датой на машине
