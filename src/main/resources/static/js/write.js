console.log("write");
let count = 1;
$("#fileAdd").click(function(){
    if(count<6) {
        let file = '<input type="file"  class="form-control add_ele" id="file'+count+'" name="files">'+'file'+count+'</input>';
        $("#files").append(file);
        count++;
    }else{
        alert("최대 5개만 가능");
    }


})