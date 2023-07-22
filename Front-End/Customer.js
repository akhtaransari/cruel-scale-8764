// Dummy data for customers
const customerData = [
  {
    id: 1,
    name: "John Doe",
    mobileNumber: "1234567890",
    email: "john.doe@example.com",
    status: "Active",
  },
  {
    id: 2,
    name: "Jane Smith",
    mobileNumber: "9876543210",
    email: "jane.smith@example.com",
    status: "Inactive",
  },
  // Add more dummy data as needed
];

// Function to fetch order details for a customer
async function fetchOrderDetails(orderId) {
  try {
    // Replace 'api/getOrderDetails' with the actual API endpoint to fetch order details
    const getOrderDetailsURL = `api/getOrderDetails/${orderId}`;
    const response = await fetch(getOrderDetailsURL);
    const data = await response.json();

    if (data.success) {
      const orderDetails = data.orderDetails;
      showOrderDetailsPopup(orderDetails);
    } else {
      alert(data.message);
    }
  } catch (error) {
    console.error("Error occurred while fetching order details:", error);
  }
}

// Function to show order details in a popup table
function showOrderDetailsPopup(orderDetails) {
  // Create a table to display order details
  const table = document.createElement("table");
  table.innerHTML = `
      <thead>
        <tr>
          <th>Vegetable Name</th>
          <th>Price</th>
          <th>Quantity</th>
        </tr>
      </thead>
      <tbody>
        ${orderDetails
          .map(
            (order) => `
          <tr>
            <td>${order.vegetableName}</td>
            <td>${order.price}</td>
            <td>${order.quantity}</td>
          </tr>
        `
          )
          .join("")}
      </tbody>
    `;

  // Create a popup to display the table
  const popup = document.createElement("div");
  popup.classList.add("popup");
  popup.appendChild(table);

  // Add a "Cancel Order" button to the popup
  const cancelOrderButton = document.createElement("button");
  cancelOrderButton.innerText = "Cancel Order";
  cancelOrderButton.classList.add("cancel-order-button");
  cancelOrderButton.onclick = () => {
    // Implement your logic here to cancel the order in the backend
    alert("Order has been canceled.");
    popup.remove(); // Close the popup
  };
  popup.appendChild(cancelOrderButton);

  // Add the popup to the page
  document.body.appendChild(popup);
}

// Function to populate the table with customer data
function populateTable() {
  const tableBody = document.getElementById("customer-body");
  tableBody.innerHTML = ""; // Clear the existing table rows

  customerData.forEach((customer) => {
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>${customer.mobileNumber}</td>
        <td>${customer.email}</td>
        <td>
          <button class="order-button" onclick="fetchOrderDetails(${customer.id})">Orders</button>
        </td>
        <td>${customer.status}</td>
        <td>
          <button class="update-button">Update</button>
          <button class="cancel-button">Cancel</button>
        </td>
      `;
    tableBody.appendChild(newRow);
  });
}

// Call the populateTable function on page load
populateTable();
