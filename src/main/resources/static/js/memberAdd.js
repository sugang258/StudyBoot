console.log("memberAdd");

$("#all").click(function(){
    let ch = $(this).prop("checked");
    console.log("ch : " , ch);

    $(".check").prop("checked",ch);
})
$(".check").click(function(){
    
    //let flag = false;
    $("#all").prop("checked",true);

    $(".check").each(function(idx, item){
        let ch = $(item).prop("checked");       
        if(!ch){
            flag=false;
            $("#all").prop("checked",false);

        }
        console.log("ch : ",ch);
    });
   
    //$("#all").prop("checked",flag);
});

$("#joinButton").click(function(){
    //event 강제 실행
    $("#joinForm").submit();
})



