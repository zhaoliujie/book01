<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>书籍添加</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="bower_components/bootswatch/dist/materia/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- 3.日期样式-->
    <link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        .custom-file-label::after{content:"浏览"}
    </style>

</head>
<body>
<div class="container-fluid" style="width: 80%;">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <form action="bookAdd" method="post" enctype="multipart/form-data" id="bookAddForm">
                        <div class="form-group row">
                            <label for="inputBid" class="col-sm-2 col-form-label text-right">大类名</label>
                            <div class="col-sm-10">

                                <select name="bid" class="form-control" id="inputBid">
                                    <option>--------请选择---------</option>

                                </select>



                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputSid" class="col-sm-2 col-form-label text-right">小类名</label>
                            <div class="col-sm-10">

                                <select name="sid" class="form-control" id="inputSid">


                                </select>



                            </div>
                        </div>


                        <div class="form-group row">
                            <label for="inputName" class="col-sm-2 col-form-label text-right">书名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputName" placeholder="书名" name="name">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputPrice" class="col-sm-2 col-form-label text-right">價格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPrice" placeholder="價格" name="price">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputAuthor" class="col-sm-2 col-form-label text-right">作者</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputAuthor"
                                       placeholder="作者名" name="author">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputCbs" class="col-sm-2 col-form-label text-right">出版社</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputCbs"
                                       placeholder="出版社" name="cbs">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputCbDate" class="col-sm-2 col-form-label text-right">出版日期</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputCbDate"
                                       placeholder="出版日期" name="cbDate">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputDescri" class="col-sm-2 col-form-label text-right">出版描述</label>
                            <div class="col-sm-10">

                                <textarea class="form-control" id="inputDescri" placeholder="出版描述" name="descri" ></textarea>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputPhoto" class="col-sm-2 col-form-label text-right">書的照片</label>
                            <div class="col-sm-10">
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="inputPhoto" aria-describedby="inputGroupFileAddon04" name="photo">
                                    <label class="custom-file-label" for="inputPhoto">请选择</label>
                                </div>

                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">添加</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="bower_components/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
<!-- 日期脚本 -->
<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
<!-- 日期设置中文脚本 -->
<script type="text/javascript" src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<!--添加验证脚本-->
<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
<!--设置图片上传格式脚本-->
<script type="text/javascript" src="bower_components/jquery-validation/dist/additional-methods.js"></script>
<!--错误信息提示中文脚本-->
<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
<script type="text/javascript">
    $('#inputCbDate').datepicker({
        language: 'zh-CN',
        format:'yyyy-mm-dd',
        autoclose:true,
        defaultViewDate:{
            year:new Date().getFullYear()-18
        }
    });
</script>
<script type="text/javascript">
    //现有对象
    var xml=new XMLHttpRequest();
    //开始拨号分两步,一为什么方法的请求,二为方法
    xml.open("GET","findAllBigType");
    //开始拨号
    xml.send();
    //拨号之后等待
    /*  xml.onreadystatechange=function(){
               //判断是否接受到了
          if(xml.readyState==4){  //4的意思是代表接受到了
               //判断是否接受成功
              if(xml.status==200){  //200的意思是代表接受成功
                   //让字符串中的JavaScript代码执行
                  eval(xml.responseText);

                  }

              }


          }*/

    function fillSel(types){

        for (var i = 0; i < types.length; i++) {
            //找到每个types类型里的name属性和id
            var op=new Option(types[i].name,types[i].id);
            //先找到这个文档的id,然后把上面得到types的属性和id添加到这个文档里面
            document.getElementById("inputBid").appendChild(op);
        }


    }
    function fillSmallSel(types){
        document.getElementById("inputSid").innerHTML="";
        for (var i = 0; i < types.length; i++) {
            //找到每个types类型里的name属性和id
            var op=new Option(types[i].name,types[i].id);
            //先找到这个文档的id,然后把上面得到types的属性和id添加到这个文档里面
            document.getElementById("inputSid").appendChild(op);
        }


    }

    $.ajax({
        type:"GET",
        url:"findAllBigType",
        jsonpCallback:"fillSel",
        dataType:"jsonp"
    });



    $("#inputBid").change(function(){
        $.ajax({
            dataType:"jsonp",
            url: "findAllSimallType",
            data:"bid="+$(this).val(),
            jsonpCallback:"fillSmallSel"
        });

    });

   $(function () {
       $("#bookAddForm").validate({
           rules:{//规则
              price:{//价格
            required:true,
            number:true
       },
               descri:{//描述
                  required:true,
                   maxlength:100
               },
    photo:{//设置图片上传
           required:true,//必填
       }

           },
           messages:{//错误信息显示
               price:{
                   required:"必填",
                   number:"必填",
               },

               photo:{//设置图片上传格式
                   accept:"必须是图片类型"
               }

           },
           errorElement:"div",
           errorClass:"invalid-feedback",//错误信息
highlight:function (element, errorClass,validClass) {//对错误i信息高亮显示
    $(element).addClass("is-invalid").removeClass(validClass);
},
           unheight:function (element, errorClass,validClass) {//对改正后的信息显示
               $(element).removeClass("is-invalid").addClass(validClass);
           },
validClass:"is-invalid"//对改正后的信息显示
       });
   });





</script>
</body>
</html>