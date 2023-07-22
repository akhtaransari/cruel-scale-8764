// Function to create and append a new row in the table
function addRow(stock) {
  const tableBody = document.getElementById("stock-body");
  const newRow = document.createElement("tr");
  newRow.innerHTML = `
  <td>${stock.vegId}</td>
  <td>${stock.name}</td>
  <td>${stock.price}</td>
  <td>${stock.type}</td>
  <td>${stock.quantity}</td>
  <td>
    <button class="update-button" onclick="openUpdateProductForm(${stock.vegId})">Update</button>
    <button class="delete-button" onclick="deleteProduct(${stock.vegId})">Delete</button>
  </td>
`;
  tableBody.appendChild(newRow);
}
let stockData = [];

const dummyData = [
  { vegId: 1, name: "Carrot", type: "Vegetable", price: 2.5, quantity: 50 },
  { vegId: 2, name: "Tomato", type: "Fruit", price: 1.8, quantity: 70 },
  { vegId: 3, name: "Broccoli", type: "Vegetable", price: 3.2, quantity: 30 },
];

// Function to open the Update Product modal with pre-filled form fields
function openUpdateProductForm(vegId) {
  console.log("Sheik");
  const productToUpdate = dummyData.find((product) => product.vegId === vegId);
  if (productToUpdate) {
    const modal = document.getElementById("update-product-modal");
    modal.style.display = "block";

    // Pre-fill the form fields with existing product details
    document.getElementById("update-vegId").value = productToUpdate.vegId;
    document.getElementById("update-name").value = productToUpdate.name;
    document.getElementById("update-price").value = productToUpdate.price;
    document.getElementById("update-type").value = productToUpdate.type;
    document.getElementById("update-quantity").value = productToUpdate.quantity;
  }
}

// Function to close the Update Product modal
function closeUpdateProductForm() {
  const modal = document.getElementById("update-product-modal");
  modal.style.display = "none";
}

function updateProduct(event) {
  event.preventDefault();
  const vegId = parseInt(document.getElementById("update-vegId").value);
  const name = document.getElementById("update-name").value;
  const type = document.getElementById("update-type").value;
  const price = parseFloat(document.getElementById("update-price").value);
  const quantity = parseInt(document.getElementById("update-quantity").value);

  const updatedProduct = {
    vegId: vegId,
    name: name,
    type: type,
    price: price,
    quantity: quantity,
  };

  const updateURL = `api/updateProduct/${vegId}`;

  // Make the API call using Fetch API or any other HTTP library you prefer
  fetch(updateURL, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(updatedProduct),
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.success) {
        // If the update was successful, find the product in stockData and update its details
        const productIndex = stockData.findIndex(
          (product) => product.vegId === vegId
        );
        if (productIndex !== -1) {
          stockData[productIndex] = updatedProduct;
          populateTable(); // Re-populate the table with updated data
          closeUpdateProductForm();
        }
      } else {
        // Handle error case here
        console.error("Failed to update product:", data.message);
      }
    })
    .catch((error) => {
      console.error("Error occurred while updating product:", error);
    });
  const productIndex = stockData.findIndex(
    (product) => product.vegId === vegId
  );
  if (productIndex !== -1) {
    stockData[productIndex] = updatedProduct;
    populateTable(); // Re-populate the table with updated data
    closeUpdateProductForm();
  }
}

// Function to populate the table with dummy data
function populateTable() {
  dummyData.forEach(addRow);
}

// Call the function to populate the table on page load
populateTable();

function openAddProductForm() {
  const modal = document.getElementById("add-product-modal");
  modal.style.display = "block";
}

function closeAddProductForm() {
  const modal = document.getElementById("add-product-modal");
  modal.style.display = "none";
  document.getElementById("name").value = "";
  document.getElementById("type").value = "";
  document.getElementById("price").value = "";
  document.getElementById("quantity").value = "";
}

console.log(stockData);
function addProduct() {
  const name = document.getElementById("name").value;
  const type = document.getElementById("type").value;
  const price = parseFloat(document.getElementById("price").value);
  const quantity = parseInt(document.getElementById("quantity").value);

  const newProduct = {
    name: name,
    type: type,
    price: price,
    quantity: quantity,
  };

  // POST

  stockData.push(newProduct);
  addRow(newProduct);

  closeAddProductForm();
}
// Handle form submission (you can add your logic here)
const addProductForm = document.querySelector(".add-product-form");
addProductForm.addEventListener("submit", function (event) {
  event.preventDefault();
  // Add your code to handle form submission here
  // For example, you can retrieve the form data and create a new product object
  // and then close the modal.
  addProduct();
  //   closeAddProductForm();
});

function deleteProduct(vegId) {
  // Assuming you have an API endpoint for deleting products, replace 'api/deleteProduct' with the actual endpoint URL
  const deleteURL = `api/deleteProduct/${vegId}`;

  // Make the API call using Fetch API or any other HTTP library you prefer
  fetch(deleteURL, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.success) {
        // If the deletion was successful, remove the product from the stockData array
        stockData = stockData.filter((product) => product.vegId !== vegId);
        populateTable(); // Re-populate the table with updated data
      } else {
        // Handle error case here
        console.error("Failed to delete product:", data.message);
      }
    })
    .catch((error) => {
      console.error("Error occurred while deleting product:", error);
    });
}
