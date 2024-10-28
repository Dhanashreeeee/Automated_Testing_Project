// Predefined users
const users = [
    { username: "admin", password: "1234" },
    { username: "user1", password: "password" }
];

// LocalStorage for transactions
let transactions = JSON.parse(localStorage.getItem('transactions')) || [];

// Handle login
document.getElementById('loginForm')?.addEventListener('submit', function (event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const validUser = users.find(user => user.username === username && user.password === password);

    if (validUser) {
        window.location.href = 'home.html';
    } else {
        document.getElementById('error').style.display = 'block';
    }
});

// Handle adding income
document.getElementById('incomeForm')?.addEventListener('submit', function (event) {
    event.preventDefault();
    const source = document.getElementById('source').value;
    const amount = document.getElementById('amount').value;

    const newTransaction = { id: Date.now(), source, amount };
    transactions.push(newTransaction);
    localStorage.setItem('transactions', JSON.stringify(transactions));

    alert('Income added!');
    document.getElementById('incomeForm').reset();
});

// Display transactions
function displayTransactions() {
    const table = document.getElementById('transactionTable');
    table.innerHTML = `
        <tr>
            <th>Source</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    `;

    transactions.forEach(transaction => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${transaction.source}</td>
            <td>${transaction.amount}</td>
            <td>
                <button onclick="editTransaction(${transaction.id})">Edit</button>
                <button onclick="deleteTransaction(${transaction.id})">Delete</button>
            </td>
        `;
        table.appendChild(row);
    });
}

// Handle edit transaction
function editTransaction(id) {
    const transaction = transactions.find(tr => tr.id === id);
    const newSource = prompt("Enter new source:", transaction.source);
    const newAmount = prompt("Enter new amount:", transaction.amount);

    if (newSource && newAmount) {
        transaction.source = newSource;
        transaction.amount = newAmount;
        localStorage.setItem('transactions', JSON.stringify(transactions));
        displayTransactions();
    }
}

// Handle delete transaction
function deleteTransaction(id) {
    transactions = transactions.filter(tr => tr.id !== id);
    localStorage.setItem('transactions', JSON.stringify(transactions));
    displayTransactions();
}

// Automatically load transactions on the transaction page
if (document.getElementById('transactionTable')) {
    displayTransactions();
}
