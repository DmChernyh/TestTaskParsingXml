# TestTaskParsingXml
Дан XML-файл, содержащий переписку (чат поддержки).

Структура таблицы:<br/>
ID (VARCHAR), MEDIATYPE(VARCHAR), STRUCTUREDTEXT(CLOB)<br/>
ID = полю sessionId из xml-файла<br/>
MEDIATYPE = chat<br/>
STRUCTUREDTEXT = заполняется предоставленным файлом (содержим из файла)

Создать REST API:<br/>
Первая API получает список всех интеракций.<br/>
Endpoint = /interactionsList?mediaType=<значение как в таблице по полю MEDIATYPE>.<br/>
mediaType - обязательно поле. Если не указано, то вывести сообщение с ошибкой.<br/>
Данный endpopint должен вывести информацию из пути xml = chatTranscript.userData

Вторая API должна выводить содержимое по определенной интеракции<br/>
Endpoint = /interaction/< interactionId >, interactionId = sessionId<br/>
Параметр interactionId - является обязательным. В случае не ввода - вывести информацию об ошибке<br/>
Данный endpoint должен вывести переписку по заданной интеракции.<br/>
По переписке вывести - время сообщения, кто писал, само сообщение

Основной фреймворк - Sprint boot, для парсинга xml - можно написать самому инструмент, либо воспользоваться готовыми
фреймворками
