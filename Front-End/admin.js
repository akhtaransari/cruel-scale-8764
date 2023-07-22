function toggleDropdown(type) {
  const dropdownContent = document.getElementById(`${type}-dropdown`);
  dropdownContent.style.display =
    dropdownContent.style.display === "block" ? "none" : "block";
}

