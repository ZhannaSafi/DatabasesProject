Смесь баз данных - как уживаются в одном проекте несколько подключений к разным типам баз данных. 

1. Создано подключение к реляционной базе данных Postgres и к нереляционной базе MongoDB
2. Суть функции проекта сводится к сохранению мета-информации каждого запроса в отдельную базу данных без заранее закрепленной структуры, в то время как основная информация будет поступать в реляционную базу Postgres
3. В этом проекте используется паттерн проектирования DAO
