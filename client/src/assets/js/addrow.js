$(document).ready(function () {
  var counter = 0;

  $("#addrow").on("click", function () {
    var newRow = $("<tr>");
    var cols = "";

    cols += '<td><input type="text" class="form-control" name="vaccin' + counter + '"/></td>';
    cols += '<td><input type="checkbox" class="form-control" name="fait' + counter + '"/></td>';



    newRow.append(cols);
    $("table.order-list").append(newRow);
    counter++;
  });



});



function calculateRow(row) {
  var price = +row.find('input[vaccin^="price"]').val();

}

function calculateGrandTotal() {
  var grandTotal = 0;
  $("table.order-list").find('input[vaccin^="price"]').each(function () {
    grandTotal += +$(this).val();
  });
  $("#grandtotal").text(grandTotal.toFixed(2));
}
