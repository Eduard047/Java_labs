# 1: Реалізація класу BankAccount
### 1.1 Створити клас BankAccount зі змінними класу accountNumber, accountName і balance.

### 1.2 Реалізувати конструктор класу, який приймає accountNumber, accountName і initialDeposit (початковий залишок) для ініціалізації об'єкта.

### 1.3 Додати методи:

#### deposit(double amount): для збільшення залишку рахунку.
#### withdraw(double amount): для зменшення залишку рахунку.
#### getBalance(): для отримання поточного залишку рахунку.
#### getAccountSummary(): для отримання інформації про рахунок.

# 2: Створення спеціалізованих класів винятків
### 2.1 Створити клас InsufficientFundsException, який розширює клас Exception. Цей виняток буде викликатися, коли недостатньо коштів для зняття грошей.

### 2.2 Створити клас NegativeAmountException, який розширює клас Exception. Цей виняток буде викликатися, коли намагаються внести або зняти від'ємну суму.

### 2.3 Створити клас AccountNotFoundException, який розширює клас Exception. Цей виняток буде викликатися, коли рахунок не знайдено.

# 3: Реалізація класу Bank
### 3.1 Створити клас Bank, який зберігає колекцію об'єктів BankAccount.

### 3.2 Реалізувати метод createAccount(String accountName, double initialDeposit), який створює новий рахунок з заданою назвою та початковим залишком.

### 3.3 Реалізувати метод findAccount(int accountNumber), який повертає об'єкт BankAccount за його номером або викидає AccountNotFoundException, якщо рахунок не знайдено.

### 3.4 Реалізувати метод transferMoney(int fromAccountNumber, int toAccountNumber, double amount), який перекладає гроші з одного рахунку на інший. Обробляйте винятки, такі як InsufficientFundsException, NegativeAmountException та AccountNotFoundException.

# 4: Тестування
### 4.1 Створити тестовий клас для класу BankAccount, де ви тестуєте роботу методів deposit, withdraw, getBalance та getAccountSummary.

### 4.2 Створити тестовий клас для класу Bank, де ви тестуєте роботу методів createAccount, findAccount та transferMoney, оброблюючи винятки.

### 4.3 Переконатися, що тестові сценарії включають в себе різні ситуації, такі як недостатні кошти, від'ємна сума, пошук рахунку тощо.