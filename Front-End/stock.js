// Function to fetch stock details
async function fetchStockDetails() {
  try {
    const getStockDetailsURL = "http://localhost:8080/Vegetables/admin"; // Replace with the actual API endpoint
    const response = await fetch(getStockDetailsURL);
    const data = await response.json();

    if (data && data.length > 0) {
      populateTable(data);
    } else {
      alert("No stock details found.");
    }
  } catch (error) {
    console.error("Error occurred while fetching stock details:", error);
    alert("Failed to fetch stock details.");
  }
}

// Function to populate the table with stock details
function populateTable(stockList) {
  const tableBody = document.getElementById("stock-body");
  tableBody.innerHTML = ""; // Clear the existing table rows

  stockList.forEach((vegetable) => {
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
        <td>${vegetable.vegId}</td>
        <td>${vegetable.name}</td>
        <td>${vegetable.type}</td>
        <td>$${vegetable.price.toFixed(2)}</td>
        <td>${vegetable.quantity}</td>
        <td>
          <button class="update-button" onclick="openUpdateForm(${JSON.stringify(
            vegetable
          )})">Update</button>
          <button class="delete-button" onclick="deleteVegetable(${
            vegetable.vegetableId
          })">Delete</button>
        </td>
      `;
    tableBody.appendChild(newRow);
  });
}

// Function to open the update form popup
// ... (Previous code)

// Function to open the update form popup
function openUpdateForm(vegetable) {
  const popupContainer = document.createElement("div");
  popupContainer.classList.add("popup-container");

  const updatePopup = document.createElement("div");
  updatePopup.classList.add("popup");
  updatePopup.innerHTML = `
    <h3>Update Vegetable - ${vegetable.name}</h3>
    <form>
      <label for="update-name">Name:</label>
      <input type="text" id="update-name" value="${vegetable.name}" required>

      <label for="update-type">Type:</label>
      <input type="text" id="update-type" value="${vegetable.type}" required>

      <label for="update-price">Price:</label>
      <input type="number" id="update-price" value="${vegetable.price}" required step="0.01">

      <label for="update-quantity">Quantity:</label>
      <input type="number" id="update-quantity" value="${vegetable.quantity}" required>
      
      <button type="submit" class="update-submit-button">Update</button>
      <button type="button" class="close-button" onclick="closePopup()">Close</button>
    </form>
  `;

  updatePopup.addEventListener("submit", (event) => {
    event.preventDefault();
    const updatedVegetable = {
      vegetableId: vegetable.vegetableId,
      name: document.getElementById("update-name").value,
      type: document.getElementById("update-type").value,
      price: parseFloat(document.getElementById("update-price").value),
      quantity: parseInt(document.getElementById("update-quantity").value),
    };

    updateVegetable(updatedVegetable);
    closePopup();
  });

  popupContainer.appendChild(updatePopup);
  document.body.appendChild(popupContainer);
}

// ... (Continue with the rest of the previous code)

// Function to delete a vegetable
async function deleteVegetable(vegetableId) {
  const confirmDelete = confirm(
    "Are you sure you want to delete this vegetable?"
  );
  if (!confirmDelete) return;

  try {
    const deleteURL = `http://localhost:8080/VegetablesDelete/admin/${vegetableId}`;
    const response = await fetch(deleteURL, { method: "DELETE" });

    if (response.ok) {
      alert("Vegetable deleted successfully.");
      fetchStockDetails(); // Refresh the table after deletion
    } else {
      alert("Failed to delete the vegetable.");
    }
  } catch (error) {
    console.error("Error occurred while deleting the vegetable:", error);
    alert("Failed to delete the vegetable.");
  }
}

// Function to update a vegetable
async function updateVegetable(updatedVegetable) {
  try {
    const updateURL = "http://localhost:8080/VegetablesUpdate/admin";
    const response = await fetch(updateURL, {
      method: "PATCH",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedVegetable),
    });

    if (response.ok) {
      alert("Vegetable updated successfully.");
      fetchStockDetails(); // Refresh the table after updating
    } else {
      alert("Failed to update the vegetable.");
    }
  } catch (error) {
    console.error("Error occurred while updating the vegetable:", error);
    alert("Failed to update the vegetable.");
  }
}

// Function to close the popup
function closePopup() {
  const popupContainer = document.querySelector(".popup-container");
  if (popupContainer) {
    popupContainer.remove();
  }
}

fetchStockDetails();

function openAddProductForm() {
  const popupContainer = document.createElement("div");
  popupContainer.classList.add("popup-container");

  const addPopup = document.createElement("div");
  addPopup.classList.add("popup");
  addPopup.innerHTML = `
      <h3>Add a New Vegetable</h3>
      <form>
        <label for="add-name">Name:</label>
        <input type="text" id="add-name" required>
  
        <label for="add-type">Type:</label>
        <input type="text" id="add-type" required>
  
        <label for="add-price">Price:</label>
        <input type="number" id="add-price" required step="0.01">
  
        <label for="add-quantity">Quantity:</label>
        <input type="number" id="add-quantity" required>
        
        <button type="submit" class="add-submit-button">Add Product</button>
        <button type="button" class="close-button" onclick="closePopup()">Close</button>
      </form>
    `;

  addPopup.addEventListener("submit", (event) => {
    event.preventDefault();
    const newVegetable = {
      name: document.getElementById("add-name").value,
      type: document.getElementById("add-type").value,
      price: parseFloat(document.getElementById("add-price").value),
      quantity: parseFloat(document.getElementById("add-quantity").value),
    };

    addVegetable(newVegetable);
    closePopup();
  });

  popupContainer.appendChild(addPopup);
  document.body.appendChild(popupContainer);
}

// Function to add a new vegetable
async function addVegetable(newVegetable) {
  try {
    const addURL = "http://localhost:8080/VegetablesAdd/admin";
    const response = await fetch(addURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newVegetable),
    });

    if (response.ok) {
      alert("New vegetable added successfully.");
      fetchStockDetails(); // Refresh the table after adding
    } else {
      alert("Failed to add the new vegetable.");
    }
  } catch (error) {
    console.error("Error occurred while adding the new vegetable:", error);
    alert("Failed to add the new vegetable.");
  }
}
