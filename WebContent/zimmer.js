function addzim(){
		$.ajax({
			cache:false,
			url: "zimmerControllerAj?action=add",
			data:{
				userName:'uuu'
			},
			success: function (result)
			{
				 $('html, body').animate({
				        scrollTop: $("#ZIMMERS").offset().top
				    }, 3000); 
				$("#formzimupdate").html($(result).find("#formzim"));
			},
			dataType: 'html'
			}
		);
	}

function addzim2()
{
	event.preventDefault();
	var $form = $('#formzim'),
	zimid = $form.find('input[name="id"]').val(),
	zimname = $form.find('input[name="name"]').val(),
	a=$form.find('input[name = "action_type"]').val(),
	servlet=$form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:zimid,
			name:zimname,
			action_type:a
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#zim_rows").html($(result).find("#tablezimmer")); 
			$('#formzim').hide();
		}
	});
	}

function deletezim (x){
	
	$.ajax({
	
		cache:false,
		url: "zimmerControllerAj?action=delete&id="+x,
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			 $('html, body').animate({
			        scrollTop: $("#ZIMMERS").offset().top
			    }, 3000); 
			$("#zim_rows").html($(result).find("#tablezimmer"));
			
			
		},
		dataType: 'html'
		}
	);
}

function updatezim (x){
	$.ajax({
		cache:false,
		url: "zimmerControllerAj?action=update&id="+x,
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			 $('html, body').animate({
			        scrollTop: $("#ZIMMERS").offset().top
			    }, 3000); 
			$("#formzimupdate").html($(result).find("#formzim"));
			$('#attached_docs :option[value=""]').atrr('selected');
		},
		dataType: 'html'
		}
	);
}

function updatezim2()
	{
	event.preventDefault();
	var $form = $('#formzim'),
	zimid = $form.find('input[name="id"]').val(),
	zimname = $form.find('input[name="name"]').val(),
	a=$form.find('input[name = "action_type"]').val(),
	servlet=$form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:zimid,
			name:zimname,
			action_type:a
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#zim_rows").html($(result).find("#tablezimmer")); 
			$('#formzim').hide();
		}
	});
	}

function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}

function doadd(){
	var z = findGetParameter("action");
	if(z =="add"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}
$(document).ready(function(){
	
	  // Add smooth scrolling to all links in navbar + footer link
	  $(".navbar a[href = '#ZIMMERS'], footer a[href='#myPage']").on('click', function(event) {
		  alert("s");
		  $.ajax(
					{
						
						cache: false,
						url:"zimmerControllerAj?action=zimmerlist",
						data:{xxx:"xxx"},
						success: function(result)
						{
							$("#zim_rows").html($(result).find("#tablezimmer"));
						},
						dataType: 'html'
						
					}		
			);
	    // Make sure this.hash has a value before overriding default behavior
	    if (this.hash !== "") {
	      // Prevent default anchor click behavior
	      event.preventDefault();

	      // Store hash
	      var hash = this.hash;

	      // Using jQuery's animate() method to add smooth page scroll
	      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
	      $('html, body').animate({
	        scrollTop: $(hash).offset().top
	      }, 900, function(){
	   
	        // Add hash (#) to URL when done scrolling (default click behavior)
	        window.location.hash = hash;
	      });
	    } // End if
	  });
	  
	  $(window).scroll(function() {
	    $(".slideanim").each(function(){
	      var pos = $(this).offset().top;

	      var winTop = $(window).scrollTop();
	        if (pos < winTop + 600) {
	          $(this).addClass("slide");
	        }
	    });
	  });
})