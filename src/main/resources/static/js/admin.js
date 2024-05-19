$(document).ready(function() {
    $(".edit-user").on("click", function(event) {
        event.preventDefault();

        var userId = $(this).data("userId");

        var url = "/admin/users/update/" + userId;
        var newLastname = $(this).parent().siblings().find(".user-lastname[data-user-id='" + userId + "']").val();
        var newFirstname = $(this).parent().siblings().find(".user-firstname[data-user-id='" + userId + "']").val();
        var newEmail = $(this).parent().siblings().find(".user-email[data-user-id='" + userId + "']").val();
        var newLangue = $(this).parent().siblings().find(".user-langue[data-user-id='" + userId + "']").val();
        var newRole = $(this).parent().siblings().find(".user-role[data-user-id='" + userId + "']").val();

        updateUser(userId, newLastname, newFirstname, newEmail, newLangue, newRole);
    });

    function updateUser(userId, newLastname, newFirstname, newEmail, newLangue, newRole) {
      var url = "/admin/users/update/" + userId; // Replace with your actual URL structure (if different)
          $.ajax({
              url: url,
              method: "POST",
              data: JSON.stringify({ // Convert to JSON string
                  id: userId,
                  lastname: newLastname,
                  firstname: newFirstname,
                  email: newEmail,
                  langue: newLangue,
                  role: newRole
              }),
            success: function(response) {
                // Update the table row with the new data (if successful)
                updateTableRow(userId, newLastname, newFirstname, newEmail, newLangue, newRole);
            },
            error: function(error) {
                // Handle any errors that occur during the update process
                console.error("Error updating user:", error);
                alert("Error updating user. Please try again."); // Add an error message alert
            }
        });
    }

    function updateTableRow(userId, newLastname, newFirstname, newEmail, newLangue, newRole) {
        var row = $("tr[data-user-id='" + userId + "']");
        row.find("td:eq(1)").text(newLastname);
        row.find("td:eq(2)").text(newFirstname);
        row.find("td:eq(3)").text(newEmail);
        row.find("td:eq(4)").text(newLangue);
        row.find("td:eq(5)").text(newRole);
    }
});