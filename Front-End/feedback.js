// Function to fetch feedback details
async function fetchFeedbackDetails() {
  try {
    const getFeedbackDetailsURL = "http://localhost:8080/Feedback/admin"; // Replace with the actual API endpoint
    const response = await fetch(getFeedbackDetailsURL);
    const data = await response.json();

    if (data && data.length > 0) {
      populateTable(data);
    } else {
      alert("No feedback details found.");
    }
  } catch (error) {
    console.error("Error occurred while fetching feedback details:", error);
    alert("Failed to fetch feedback details.");
  }
}

// Function to populate the table with feedback details
function populateTable(feedbackList) {
  const tableBody = document.getElementById("feedback-body");
  tableBody.innerHTML = ""; // Clear the existing table rows

  feedbackList.forEach((feedback) => {
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
        <td>${feedback.feedbackId}</td>
        <td>${feedback.customerId}</td>
        <td>${feedback.vegetableId}</td>
        <td>${feedback.rating}</td>
        <td>${feedback.comments}</td>
      `;
    tableBody.appendChild(newRow);
  });
}

// Call the fetchFeedbackDetails function on page load
fetchFeedbackDetails();
