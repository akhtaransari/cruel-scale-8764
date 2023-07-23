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

// Function to open the update order form popup
function openUpdateForm(order) {
  // Create a popup container
  const popupContainer = document.createElement("div");
  popupContainer.classList.add("popup-container");

  // Create the update form
  const updateForm = document.createElement("form");
  updateForm.classList.add("update-form");
  updateForm.innerHTML = `
      <label for="orderId">Order ID:</label>
      <input type="text" id="orderId" value="${order.orderId}" readonly>
      <label for="customerId">Customer ID:</label>
      <input type="text" id="customerId" value="${order.customerId}" readonly>
      <label for="name">Name:</label>
      <input type="text" id="name" value="${order.name}">
      <label for="vegetables">Vegetables (Comma-separated):</label>
      <input type="text" id="vegetables" value="${order.vegetables.join(", ")}">
      <label for="totalAmount">Total Amount:</label>
      <input type="text" id="totalAmount" value="${order.totalAmount}">
      <label for="status">Status:</label>
      <input type="text" id="status" value="${order.status}">
      <button type="button" class="update-order-button">Update Order</button>
      <button type="button" class="close-button">Close</button>
    `;

  // Add event listener to the "Update Order" button
  updateForm
    .querySelector(".update-order-button")
    .addEventListener("click", () => {
      updateOrder(order.orderId);
    });

  // Add event listener to the "Close" button
  updateForm.querySelector(".close-button").addEventListener("click", () => {
    popupContainer.remove(); // Close the popup
  });

  // Append the update form to the popup container
  popupContainer.appendChild(updateForm);

  // Append the popup container to the body
  document.body.appendChild(popupContainer);
}

// Function to delete the order
async function deleteOrder(orderId) {
  try {
    const deleteOrderURL = `http://localhost:8080/CancelOrder/admin/${orderId}`; // Replace with the actual API endpoint
    const response = await fetch(deleteOrderURL, {
      method: "DELETE",
    });

    const data = await response.json();
    if (data.success) {
      alert("Order canceled successfully.");
      // Refresh the table with updated data after successful deletion
      fetchOrderDetails();
    } else {
      alert(data.message);
    }
  } catch (error) {
    console.error("Error occurred while canceling order:", error);
    alert("Failed to cancel order.");
  }
}

// Function to fetch order details for a customer
async function fetchOrderDetails() {
  try {
    const getOrderDetailsURL = "http://localhost:8080/Orders/admin"; // Replace with the actual API endpoint
    const response = await fetch(getOrderDetailsURL);
    const data = await response.json();
    console.log(data);
    if (data && data.orders && data.orders.length > 0) {
      populateTable(data.orders);
    } else {
      alert("No order details found.");
    }
  } catch (error) {
    console.error("Error occurred while fetching order details:", error);
    alert("Failed to fetch order details.");
  }
}

// Function to populate the table with order details
// function populateTable(orders) {
//   const tableBody = document.getElementById("customer-body");
//   tableBody.innerHTML = ""; // Clear the existing table rows

//   orders.forEach((order) => {
//     const newRow = documdent.createElement("tr");
//     newRow.innerHTML = `
//         <td>${order.orderId}</td>
//         <td>${order.customerId}</td>
//         <td>${order.name}</td>
//         <td>${order.vegetables.join(", ")}</td>
//         <td>${order.totalAmount}</td>
//         <td>${order.status}</td>
//         <td>
//           <button class="update-button" onclick="openUpdateForm(${JSON.stringify(
//             order
//           )})">Update</button>
//           <button class="cancel-button" onclick="deleteOrder(${
//             order.orderId
//           })">Cancel</button>
//         </td>
//       `;
//     tableBody.appendChild(newRow);
//   });
// }

// Call the fetchOrderDetails function on page load
fetchOrderDetails();

// Function to open the order details popup
function openOrderDetails(order) {
  // Create a popup container
  const popupContainer = document.createElement("div");
  popupContainer.classList.add("popup-container");

  // Create the order details popup
  const orderDetailsPopup = document.createElement("div");
  orderDetailsPopup.classList.add("popup");
  orderDetailsPopup.innerHTML = `
      <h3>Order Details - Order ID: ${order.orderId}</h3>
      <table>
        <thead>
          <tr>
            <th>Vegetable Name</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          ${order.vegetables
            .map(
              (vegetable) => `
                <tr>
                  <td>${vegetable.name}</td>
                  <td>$${vegetable.price.toFixed(2)}</td>
                  <td>${vegetable.quantity}</td>
                </tr>
              `
            )
            .join("")}
        </tbody>
      </table>
      <button class="close-button">Close</button>
    `;

  // Add event listener to the "Close" button
  orderDetailsPopup
    .querySelector(".close-button")
    .addEventListener("click", () => {
      popupContainer.remove(); // Close the popup
    });

  // Append the order details popup to the popup container
  popupContainer.appendChild(orderDetailsPopup);

  // Append the popup container to the body
  document.body.appendChild(popupContainer);
}

function populateTable(orders) {
  // ... (Previous implementation for populating the table) ...
  const tableBody = document.getElementById("customer-body");
  tableBody.innerHTML = "";
  orders.forEach((customer) => {
    customer.orders.forEach((order) => {
      const newRow = document.createElement("tr");
      newRow.innerHTML = `
          <td>${order.orderId}</td>
          <td>${customer.id}</td>
          <td>
            <button class="order-details-button" onclick="openOrderDetails(${JSON.stringify(
              order
            )})">Order Details</button>
          </td>
          <td>$${order.totalAmount.toFixed(2)}</td>
          <td>${order.status}</td>
          <td>
            <button class="update-button" onclick="openUpdateForm(${JSON.stringify(
              order
            )})">Update</button>
            <button class="cancel-button" onclick="deleteOrder(${
              order.orderId
            })">Cancel</button>
          </td>
        `;
      tableBody.appendChild(newRow);
    });
  });
}

// Call the fetchOrderDetails function on page load
fetchOrderDetails();
